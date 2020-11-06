package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone"})})
public class User extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=40)
    private String surname;

    @Size(max=40)
    private String name;

    @Size(max=40)
    private String lastname;

    @Size(max=30)
    private String username = "default";

    @NotBlank
    @Size(max=15)
    private String phone;

    private String email;

    private String password;

    private byte[] avatar;

    private String disposablePassword;

    /**
     * (RU)Список заказов
     * (Eng) Order List
     *
     * */

    private List<Orders> ordersList;

    private Role roles = new HashSet<>();

    private String city;

}
