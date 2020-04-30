package spring.security.model;

/**
 * @Created 24 / 04 / 2020 - 12:51 PM
 * @project SpringSecurityJWT
 * @Author Hamdamboy
 */
public class LoginViewModel {

    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
