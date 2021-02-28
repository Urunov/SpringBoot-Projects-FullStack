package com.urunov.jwtauth.gitProxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepoCommitResponse {
    //
    private String id;
    private String short_id;
    private String create_at;
    private List<String> parents_ids;
    private String title;
    private String message;
    private String author_name;
    private String author_email;
    private String author_date;
    private String committer_name;
    private String committer_email;
    private String committer_date;
    private String web_url;
    private GitProjectStat stats;
}
