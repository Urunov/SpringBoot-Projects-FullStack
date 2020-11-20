package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone"})})
public class User extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    private String surname;

    @Size(max = 40)
    private String name;

    @Size(max = 40)
    private String lastname;

    @Size(max = 30)
    private String username = "default";

    @NotBlank
    @Size(max = 15)
    private String phone;

    @Size(max = 40)
    @Email
    private String email;

    @Column(name = "password", columnDefinition = "char(60)")
    private String password;

    @Lob
    private byte[] avatar;

    private String disposablePassword;

    private String city;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
//
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Orders> ordersList;
}
