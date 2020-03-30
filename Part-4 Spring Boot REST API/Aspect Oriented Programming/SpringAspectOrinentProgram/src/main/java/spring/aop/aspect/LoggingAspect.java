package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Arrays;

/**
 * @Created 24 / 03 / 2020 - 5:48 PM
 * @project SpringAspectOrinentProgram
 * @Author Hamdamboy
 */

@Aspect
@Component
public class LoggingAspect {
    //
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /***
     * Aspect Orient Programming (AOP)
     * PointCut that match all repositoies, services and WEB REST endpoints.
     *
     * */

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            "|| within(@org.springframework.stereotype.Service * )" +
            "|| within(@org.springframework.web.bind.annotation.RestController *)")

    public void springBeanPointcut() {
        //method is empty as this is just a Pointcut, the implementations are in the advices.
    }
    //https://www.javaguides.net/p/spring-boot-tutorial.html

    /***
     *  PointCut that matches all Spring beans in the application's main packages.
     * */

    @Pointcut("within(spring.aop.aspect..*)" +
            "|| within(spring.aop.aspect.service..*)" +
            "|| within( spring.aop.aspect.controller..*)")

    public void applicationPackagePointcut() {
        // Method is empty as this is just a pointcut, the implementations are the advices.
    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */

    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{} with cause = {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */

    @Around("applicationPackagePointcut() && springBeanPointcut()")

    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if(log.isDebugEnabled()) {
            log.debug("Enter : {}.{} with argument[s] = {}", joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }

        try {
            Object result = joinPoint.proceed();
            if(log.isDebugEnabled()) {
                log.debug("Exit: {}.{} () with result ={}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }

            return result;
        } catch (IllegalAccessError e){
            log.error("Illegal argument: {} in {}.{} ()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }


}
