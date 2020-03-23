package spring.basic;

import com.sun.istack.internal.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import javax.validation.constraints.Size;

import java.util.List;

/**
 * @Created 23 / 03 / 2020 - 1:47 PM
 * @project SpringEmailProcess
 * @Author Hamdamboy
 */

@ConfigurationProperties(prefix="myapp.mail")
@Validated
public class MailProperties{
    //

    @Email
    private String to;
    @NotNull
    private String host;
    private int port;
    private String[] cc;
    private List<String> bcc;

    @Valid
    private Credential credential = new Credential();

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }


    public class Credential {

        @NotNull
        private String userName;

        @Size(max= 15, min=6)
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
