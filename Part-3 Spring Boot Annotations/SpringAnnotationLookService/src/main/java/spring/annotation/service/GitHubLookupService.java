package spring.annotation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import spring.annotation.model.User;

import java.util.concurrent.CompletableFuture;

/**
 * @Created 30 / 03 / 2020 - 3:21 PM
 * @project Springannotation
 * @Author Hamdamboy
 */

@Service
public class GitHubLookupService {
    //
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;


    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
       this.restTemplate = restTemplateBuilder.build();
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up : " + user);
        String url = String.format("https://api.github.com/user/%s", user);
        User results = restTemplate.getForObject(url, User.class);

        //Artificial delay of 1st for demonstration purpose
        Thread.sleep(1000);

        return CompletableFuture.completedFuture(results);
    }
}
