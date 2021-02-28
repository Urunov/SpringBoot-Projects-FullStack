package com.urunov.jwtauth.gitProxy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class GitAPIService  {
    //
    private static final String API_RESOURCE = "https://gitlab.com";
    private static final String API_BaseUrl = "/api/v4/projects/";
    private static final String REPO_COMMIT = "/repository/commits";
    private static final String With_Stats = "?with_stats=true";
    private static final String ALL_COMMITS = "&all=true";
    // ISO format
    private static final String StartTime = "T00:00:00.000+00:00";
    private static final String EndTime = "T23:59:00.000+00:00";
    private static final String SINCE= "&since=";
    private static final String UNTIL = "&until=";


    public List<GitRepoCommitResponse> findAllRepo(String gitToken, String projectId) throws IOException {
        //
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(API_RESOURCE).append(API_BaseUrl).append(projectId).append(REPO_COMMIT).
                append(With_Stats).append(ALL_COMMITS);
        URL url = new URL(uriBuilder.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Authorization","Bearer "+ gitToken);
        connection.setRequestProperty("Content-Type","application/json");
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;

        StringBuilder response = new StringBuilder();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        // JSON to Object convert
        ObjectMapper objectMapper = new ObjectMapper();
        List<GitRepoCommitResponse> solutions = objectMapper.readValue(response.toString().getBytes(StandardCharsets.UTF_8), new TypeReference<List<GitRepoCommitResponse>>() {});


        in.close();
        return solutions;
    }

}
