package posilka.admin.model;

/**
 * @Created 06 / 05 / 2020 - 11:58 AM
 * @project AdminPage
 * @Author Hamdamboy
 */
public class User {

    private long id;
    private String UserName;
    private String UserPassword;
    private int active;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    private String roles = "";
    private String permission="";

    public User(String userName, String userPassword, int active, String roles, String permission) {
        UserName = userName;
        UserPassword = userPassword;
        this.active = active;
        this.roles = roles;
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }



    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
