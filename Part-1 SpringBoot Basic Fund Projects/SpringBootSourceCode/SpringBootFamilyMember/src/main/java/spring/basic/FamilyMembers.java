package spring.basic;


/**
 @Author: ${USER}
 @created on ${DATE}
 @Project is ${PROJECT_NAME}
 */


public class FamilyMembers {
    //
    private final Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nation;


    public FamilyMembers(Long id, String firstName, String lastName, int age, String nation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nation = nation;

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
