package com.urunov.pairing.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "GitCommit")
public class GitCommit {
    //

    public int id;
    public String description;
    public String name_with_namespace;
    public String path;
    public String path_with_namespace;
    public String created_at;
    public String default_branch;
    public List<String> tag_list;
    public String ssh_url_to_repo;
    public String  http_url_to_repo;
    public String  web_url;
    public String  readme_url;
    public String  avatar_url;
    public int    forks_count;
    public int   star_count;
    public String  last_activity_at;
    public GitNamespace namespace;

}
/***                                               {username}
 * ResourceUrl = "https://gitlab.com/api/v4/users/urunovtimes/projects";
 *
 *    // String ResourceUrl = "https://gitlab.com/api/v4/users/urunovtimes/";
 * */