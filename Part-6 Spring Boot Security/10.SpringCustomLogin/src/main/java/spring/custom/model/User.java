package spring.custom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Created 21 / 04 / 2020 - 11:12 AM
 * @project custom
 * @Author Hamdamboy
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles ="";

    private String permissions ="";

    public User(){}

    public User(String username, String password, String roles, String permissions) {

        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }



    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<String> getRoleList() {
       if(this.roles.length() > 0) {
           return Arrays.asList(this.roles.split(","));
       }
       return new ArrayList<>();
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<String> getPermissionList() {
        if(this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
