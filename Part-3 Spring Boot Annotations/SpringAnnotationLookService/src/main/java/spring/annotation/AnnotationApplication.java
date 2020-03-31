package spring.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import spring.annotation.model.User;
import spring.annotation.service.GitHubLookupService;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
public class AnnotationApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationApplication.class);


    @Autowired
    private GitHubLookupService githubLookupService;

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }

    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Start the clock

        long start = System.currentTimeMillis();
        //kick of multiple, asynchronous lookups

        CompletableFuture <User>   page1 = githubLookupService.findUser("PivotalSoftware");
        CompletableFuture < User > page2 = githubLookupService.findUser("CloudFoundry");
        CompletableFuture < User > page3 = githubLookupService.findUser("Spring-Projects");
        CompletableFuture < User > page4 = githubLookupService.findUser("Hamdambek");
        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3, page4).join();

        // Print results, including elapsed time

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
        logger.info("--> " + page4.get());
    }



}
