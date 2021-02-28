package com.urunov.jwtauth.gitProxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitProjectStat {
    private int additions;
    private int deletions;
    private int total;
}
