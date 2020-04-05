package spring.swagger2;

/**
 * @Author: apple
 * @created on 05/04/2020
 * @Project is SpringSwagger2Project
 */


public class Student {
    //
    private String name;
    private String cls;
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty()  {
        return country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


    public Student (String name, String cls, String country){
        super();
        this.name = name;
        this.cls = cls;
        this.country = country;
    }


    public String getName() {
        return name;
    }
}
