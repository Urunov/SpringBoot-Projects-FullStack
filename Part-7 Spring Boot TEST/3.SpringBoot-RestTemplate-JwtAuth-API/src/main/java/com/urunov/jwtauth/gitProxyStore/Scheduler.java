package com.urunov.jwtauth.gitProxyStore;

import com.urunov.jwtauth.gitProxy.GitStat;
import com.urunov.jwtauth.store.GitStatStore;
import com.urunov.jwtauth.store.Offset;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class
Scheduler {
    //
    GitStatStore gitStatStore;

    String fooResourceUrl= "http://localhost:9093/api/publish/";

   // @Scheduled(cron = "0 0 0 * * *")  // @Daily once
    @Scheduled(cron = "*/40 * * * * *")
    public void crawlGitlabRepo() {

        Offset offset = new Offset(0, 20); // maximum 20
        boolean isContinue = true;

        while (isContinue){
            List<GitStat> allGitStat = gitStatStore.retrieveAll(offset);
            if (allGitStat.size() == 0)
                return;
            if (allGitStat.size() < 20)
                isContinue = false;

            for (GitStat gitStat : allGitStat) {
                String message = "";
                if (gitStat.getProjectId().equals("") || gitStat.getProjectId().isEmpty())
                {
                    message = findProjectIdMessage(gitStat.getProjectId(), gitStat.getGitToken(), gitStat.getUserGitName());
                }
                else
                {
                    message = modifyProjectCommitMessage(gitStat.getProjectId(), gitStat.getGitToken(), gitStat.getUserGitName());
                }
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl+message, String.class);
            }
        }
    }

    private String findProjectIdMessage(String projectId, String gitToken, String userId){
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("1|").append(projectId).append("|").append(gitToken).append("|").append(userId);
        return messageBuilder.toString();
    }
    private String modifyProjectCommitMessage(String projectId, String gitToken, String userId){
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("2|").append(projectId).append("|").append(gitToken).append("|").append(userId);
        return messageBuilder.toString();
    }
}
