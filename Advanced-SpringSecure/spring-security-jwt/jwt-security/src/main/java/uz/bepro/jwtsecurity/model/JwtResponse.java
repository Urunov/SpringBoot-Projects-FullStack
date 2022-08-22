package uz.bepro.jwtsecurity.model;

import java.io.Serializable;

/**
 * @project: jwt-security
 * @Date: 19.08.2022
 * @author: H_Urunov
 **/

public class JwtResponse implements Serializable {
    //
    private static final long serialVersionUID = 8091879091924046844L;

    private final String jwttoken;


    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken(){
        return this.jwttoken;

    }
}
