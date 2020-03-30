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
import spring.annotation.model.Developer;
import spring.annotation.service.GithubLookupService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
public class AnnotationApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }

    @Autowired
    private GithubLookupService githubLookupService;

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }


    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();
        //kick of multiple, asynchronous lookups
        CompletableFuture<Developer> page1 = githubLookupService.findDeveloper("Urunov");
        CompletableFuture < Developer > page2 = githubLookupService.findDeveloper("SpringBoot-Database");
        CompletableFuture < Developer > page3 = githubLookupService.findDeveloper("Spring-Projects");
        CompletableFuture < Developer > page4 = githubLookupService.findDeveloper("Hamdamboy");
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
