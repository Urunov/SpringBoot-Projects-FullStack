package spring.jsp;

/**
 * @Created 22 / 05 / 2020 - 3:43 PM
 * @project SpringJSPUpdate
 * @Author Hamdamboy
 */
public class User {

    private String name;
    private String address;
    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
