package uz.be.springrolebaseauth.security;

/**
 * @project: secure-start
 * @Date: 12.08.2022
 * @author: H_Urunov
 **/

public enum ApplicationUserPermission {
    STUDENT_READ("student: read"),
    STUDENT_WRITE("student: write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course: write");
    private final String permission;
    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
