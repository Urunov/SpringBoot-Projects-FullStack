package spring.database.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Created 17 / 04 / 2020 - 1:38 PM
 * @project SpringSecureDB
 * @Author Hamdamboy
 */

@Entity
//@Table(catalog = "secure")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles="";

    private String permission="";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        if(this.permission.length() >0){
            return Arrays.asList(this.permission.split(","));
        }
        return new ArrayList<>();
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User(){

    }
    public User(String username, String password, String roles, String permission) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permission = permission;
        this.active = 1;

    }
}
