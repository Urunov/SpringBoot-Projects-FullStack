package com.urunov.pairing.events;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urunov.pairing.data.GitCommit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GitlabAPIService {

    private static final String API_RESOURCE = "https://gitlab.com";
    private static final String API_NAMESPACE = "/api/v4";
    private static final String API_USERS = "/users/";
    private static final String API_PROJECTS = "/projects";

    private static String API_USERNAME="urunovtimes"; // coming from Frontend UI that is userID or username

    public static void gitResponse() throws JsonProcessingException {
        //
        RestTemplate restTemplate = new RestTemplate();

        StringBuilder apiBuilder = new StringBuilder();
        apiBuilder.append(API_RESOURCE).append(API_NAMESPACE).append(API_USERS).append(API_USERNAME).append(API_PROJECTS);
        ResponseEntity<String> response = restTemplate.getForEntity(apiBuilder.toString(), String.class);

        // JSON to Object convert
        ObjectMapper objectMapper = new ObjectMapper();
        List<GitCommit>  solutions = objectMapper.readValue(response.getBody(), new TypeReference<List<GitCommit>>(){});
        solutions.size();

        System.out.println(solutions.size());
  //      System.out.println("=> " + solutions);
       System.out.println(response);
    }

}

