package com.urunov.pairing.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "gitnamespace")
public class GitNamespace {
    //
    public int id;
    public String name;
    public String path;
    public String kind;
    public String full_path;
    public Integer parent_id;
    public String avatar_url;
    public String web_url;

}
