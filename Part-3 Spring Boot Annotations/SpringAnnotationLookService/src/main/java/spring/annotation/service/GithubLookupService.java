package spring.annotation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import spring.annotation.model.Developer;

import java.util.concurrent.CompletableFuture;

/**
 * @Created 30 / 03 / 2020 - 3:21 PM
 * @project Springannotation
 * @Author Hamdamboy
 */

@Service
public class GithubLookupService {
    //
    private static final Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

    private final RestTemplate restTemplate;


    public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
       this.restTemplate = restTemplateBuilder.build();
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Developer> findDeveloper(String developer) throws InterruptedException {
        logger.info("Looking up : " + developer);
        String url = String.format("https://api.github.com/developer/%s", developer);
        Developer results = restTemplate.getForObject(url, Developer.class);

        //Artificial delay of 1st for demonstration purpose
        Thread.sleep(1000);

        return CompletableFuture.completedFuture(results);
    }
}
