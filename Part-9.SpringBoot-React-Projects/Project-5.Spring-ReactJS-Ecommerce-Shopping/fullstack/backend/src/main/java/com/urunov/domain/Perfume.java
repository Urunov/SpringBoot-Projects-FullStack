package com.urunov.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User: hamdamboy
 * Project: Ecommerce
 * Github: @urunov
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "perfumer", "perfumeTitle", "perfumeGender", "price"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please, not empty field/Пожалуйста заполните поле ")
    @Length(max = 255)
    private String perfumeTitle;

    @NotBlank(message = "Пожалуйста заполните поле")
    @Length(max = 255)
    private String perfumer;

    @NotNull(message = "Please,fill in field/ Пожалуйста заполните поле")
    private Integer year;

    @NotNull(message = "Please, fill in field/ Пожалуйста заполните поле")
    private String country;

    @NotBlank(message = "Please, fill in field / Пожалуйста заполните поле")
    private String perfumeGender;

    @NotBlank(message = "Please, fill in field, Пожалуйста заполните поле")
    @Length(max = 255)
    private String fragranceTopNotes;

    @NotBlank(message = "Please, fill in field/ Пожалуйста заполните поле")
    private String fragranceMiddleNotes;

    @NotBlank(message = "Please, fill in field/ Пожалуйста заполните поле")
    @Length(max = 255)
    private String fragranceBaseNotes;


    private String description;

    private String fileName;

    @NotBlank(message = "Please, fill in field/ Пожалуйста заполните поле")
    private Integer price;

    @NotBlank(message = "Please, fill in field/ Пожалуйста заполните поле")
    @Length(max = 255)
    private String value;

    @NotBlank(message = "Please, fill in field/ Пожалуйста заполните поле")
    @Length(max = 255)
    private String type;

//    @ManyToMany(mappedBy = "perfumes")
//    private List<User> users;

}
