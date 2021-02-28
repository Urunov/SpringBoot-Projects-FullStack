package com.urunov.jwtauth.controller;

import com.urunov.jwtauth.gitProxy.GitAPIService;
import com.urunov.jwtauth.gitProxy.GitRepoCommitResponse;
import com.urunov.jwtauth.gitProxy.GitStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    //
    @Autowired
    GitAPIService apiService;

    String gitToken ="ferZVMKxT5ncFhRuSF1v";
    String projectId = "24113189";

    @RequestMapping("/test")
    private void test() throws Exception
    {
        List<GitRepoCommitResponse> str = apiService.findAllRepo(gitToken, projectId);
        for(GitRepoCommitResponse stat: str){
            System.out.println(" "+ stat);
        }
       // System.out.println(str);
    }
}
