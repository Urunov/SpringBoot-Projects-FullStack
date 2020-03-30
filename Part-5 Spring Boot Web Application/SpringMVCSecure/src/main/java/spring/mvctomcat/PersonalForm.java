package spring.mvctomcat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Created 27 / 03 / 2020 - 4:19 PM
 * @project SpringMVCSecure
 * @Author Hamdamboy
 */

public class PersonalForm {
    //
    @NotBlank
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonalForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
