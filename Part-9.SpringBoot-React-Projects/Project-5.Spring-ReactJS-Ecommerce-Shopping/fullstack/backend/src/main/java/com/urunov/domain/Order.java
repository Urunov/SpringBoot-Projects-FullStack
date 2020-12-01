//package com.urunov.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import java.time.LocalDate;
//import java.util.List;
//
///**
// * User: hamdamboy
// * Project: Ecommerce
// * Github: @urunov
// */
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    private Double totalPrice;
//
//    private LocalDate date;
//
//    private String lastName;
//
//    private String firstName;
//
//    private String city;
//    /**
//     * Delivery address of the order.
//     * The @NotBlank annotation says the field should not be empty.
//     */
//    @NotBlank(message = "Пожалуйста заполните поле")
//    private String address;
//
//    /**
//     * Customer email.
//     * The @Email annotation says the string has to be a well-formed email address.
//     * The @NotBlank annotation says the field should not be empty.
//     */
//
//    @Email(message = "Некорректный email")
//    @NotBlank(message = "Email не может быть пустым")
//    private String email;
//
//    @NotBlank(message = "Номер телефона не может быть пустым")
//    private String phoneNumber;
//
//    private Integer postIndex;
//
////    @OrderColumn
////    @ManyToMany(fetch = FetchType.EAGER)
////    private List<Perfume> perfumeList;
////
////    /**
////     * The customer who made the order.
////     * Between the {@link Order} and {@link User} objects, there is a many-to-one relationship, that is,
////     * each record in one table is directly related to a single record in another table.
////     */
////    @ManyToOne(cascade = CascadeType.ALL)
////    private User user;
//
//
//}
