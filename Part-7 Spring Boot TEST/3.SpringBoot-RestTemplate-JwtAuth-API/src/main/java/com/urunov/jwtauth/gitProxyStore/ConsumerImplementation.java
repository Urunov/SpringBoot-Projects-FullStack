package com.urunov.jwtauth.gitProxyStore;
import com.urunov.jwtauth.gitProxy.GitAPIService;
import com.urunov.jwtauth.gitProxy.GitRepoCommitResponse;
import com.urunov.jwtauth.gitProxy.GitStat;
import com.urunov.jwtauth.store.GitStatStore;
import com.urunov.jwtauth.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ConsumerImplementation {
    RestClient restClient = new RestClient();

    @Autowired
    GitAPIService gitAPIService;


    GitStatStore gitStatStore;

    @JmsListener(destination = "local.inmemory.queue")
    public void onMessage(String content) throws InterruptedException
    {
        if (content == null || content.isEmpty())
            return;
        String[] codes = content.split("\\|");

        if (codes.length != 4)
            return;

        String operation = codes[0];

        try {
            if (operation.equals("1")){
                modifyRepoInfo(codes[1],codes[2],codes[3]);
            }
            else{
                findRepoStats(codes[1], codes[2], codes[3]);
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }

    private void modifyRepoInfo(String gitUserName, String gitToken, String projectId)
    {
        try {

            if (projectId.length() != 8)
                return;

            GitStat gitStat = gitStatStore.retrieve(projectId);
//            gitStat..setRepoId(repoId);
//            userInfoStore.update(userInfo);

            gitStat.setProjectId(projectId);

            //Needs to be processed for repo commit stat
            //Repo id must be inserted into queue (when after processing again)
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    private void findRepoStats(String gitUserName, String gitToken, String projectId) throws IOException {

        List<GitRepoCommitResponse> responses = gitAPIService.findAllRepo(gitToken, projectId);
        GitStat gitStat = new GitStat();
        int additions = 0, deletions=0, total=0;
        for (GitRepoCommitResponse response : responses)
        {
            if (response.getAuthor_name().equals(gitUserName))
            {
                deletions+= response.getStats().getDeletions();
                additions += response.getStats().getAdditions();
                total += response.getStats().getTotal();
            }

        }
        if(additions!=0 || total!=0){
            gitStat.setAdditions(String.valueOf(additions));
            gitStat.setTotal(String.valueOf(total));
            gitStat.setDeletions(String.valueOf(deletions));
            gitStat.setProjectId(projectId);
            gitStat.setUserGitName(gitUserName);

            gitStatStore.create(gitStat);
        }

//      //  boolean todayExists = false;
//        String today = Utils.getTodayDateStr();
//
//        GitStat userStat = new GitStat();
//       // userStat.setUserId(userId);
//        userStat.setAdditions(String.valueOf(additions));
//        userStat.setDeletions(String.valueOf(deletions));
//        userStat.setTotal(String.valueOf(total));
//
//
//        userStat.setDate(today);
//        userStat.setLastUpdated(Utils.getCurrentTimeStamp());
//        gitStatStore.create(userStat);
    }
}
