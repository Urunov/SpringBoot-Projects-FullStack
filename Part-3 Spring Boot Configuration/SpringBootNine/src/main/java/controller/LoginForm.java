package controller;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginForm {
    //
    @NotBlank(message = "E-mail must not be empty")
    @Email(message = "Please, enter a valid e-mail address.")
    private String email;

    @NotBlank(message = "Password must be empty.")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginForm() {
        super();
    }




}
