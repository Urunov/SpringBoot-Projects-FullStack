package com.urunov.jwtauth.gitProxy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GitStat {

    private String userGitName;
    private String gitToken;
    private String projectId;

    private String additions;
    private String deletions;
    private String total;

    private String lastUpdated;
    private String date;


}
