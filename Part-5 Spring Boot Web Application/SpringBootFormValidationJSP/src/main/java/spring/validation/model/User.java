package spring.validation.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * @Created 09 / 06 / 2020 - 1:43 PM
 * @project SpringBootValidationJSP
 * @Author Hamdamboy
 */
public class User {

    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotBlank
    private String gender;

    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String profession;

    @Size(max = 100)
    private String note;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @AssertTrue
    private boolean married;

    @Min(value = 20_000)
    @Max(value = 300_000)
    private long income;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + ", gender=" + gender + ", password=" + password
                + ", profession=" + profession + ", note=" + note + ", birthday=" + birthday + ", married=" + married
                + ", income=" + income + "]";
    }

}
