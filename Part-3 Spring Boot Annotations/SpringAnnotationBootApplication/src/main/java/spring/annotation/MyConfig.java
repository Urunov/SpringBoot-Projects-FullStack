package spring.annotation;

import org.springframework.stereotype.Component;

/**
 * @Created 31 / 03 / 2020 - 10:34 AM
 * @project SpringAnnotation
 * @Author Hamdamboy
 */

@Component
public class MyConfig {
    //
    private String identity;
    private String title;

    public String show(){
       return ("MyConfig is working again.");
    }
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
