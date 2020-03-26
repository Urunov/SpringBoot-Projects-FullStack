package com.example.demo.aspera;

/**
 * @Created 26 / 03 / 2020 - 10:44 AM
 * @project demo
 * @Author Hamdamboy
 */
public class FilesAPI {
    //
    private String member_id;
    private String member_type;


    public FilesAPI(String member_id, String member_type) {
        this.member_id = member_id;
        this.member_type = member_type;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    @Override
    public String toString() {
        return "FilesAPI{" +
                "member_id='" + member_id + '\'' +
                ", member_type='" + member_type + '\'' +
                '}';
    }

}
