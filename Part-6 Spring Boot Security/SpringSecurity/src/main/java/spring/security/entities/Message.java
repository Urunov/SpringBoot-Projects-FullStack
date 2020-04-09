package spring.security.entities;

import javax.persistence.*;

/**
 * @Created 09 / 04 / 2020 - 2:15 PM
 * @project SpringSecurity
 * @Author Hamdamboy
 */

@Entity
@Table(name="message")
public class Message {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId(){
        return id;
    }
}
