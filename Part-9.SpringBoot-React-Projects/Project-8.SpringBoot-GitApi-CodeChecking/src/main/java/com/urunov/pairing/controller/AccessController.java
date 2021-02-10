package com.urunov.pairing.controller;

import com.urunov.pairing.events.GitlabAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AccessController {

   @Autowired
   private GitlabAPIService gitlabAPI;


    @GetMapping("")
    public void response() throws Exception{
        GitlabAPIService.gitResponse();
    }

    public GitlabAPIService getGitlabAPI() {
        return gitlabAPI;
    }


}
//https://github.com/gitlab4j/gitlab4j-api#gitLab-api-v3-and-v4-support
//https://www.javatips.net/api/gitlab-api-master/java-gitlab-api-master/src/main/java/org/gitlab/api/GitlabAPI.java