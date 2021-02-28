/* 
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package com.urunov.jwtauth.store;

import com.urunov.jwtauth.gitProxy.GitStat;

import java.util.List;

public interface GitStatStore {
    /* Autogen by nara studio */
    void create(GitStat gitStat);
    GitStat retrieve(String id);
    List<GitStat> retrieveAll(Offset offset);
    void update(GitStat gitStat);
    void delete(GitStat gitStat);
    void delete(String id);
    boolean exists(String id);
}
