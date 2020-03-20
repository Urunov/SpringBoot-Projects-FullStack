package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpringDBH2 {
    //
    @Id
    private int ID;
    private String name;
    private String role;

    @Override
    public String toString() {
        return "SpringDBH2{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

    public SpringDBH2() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
