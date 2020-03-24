package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

    public void springBeanPointcut() {
        //method is empty as this is just a Pointcut, the implementations are in the advices.
    }
//https://www.javaguides.net/p/spring-boot-tutorial.html
//
}
