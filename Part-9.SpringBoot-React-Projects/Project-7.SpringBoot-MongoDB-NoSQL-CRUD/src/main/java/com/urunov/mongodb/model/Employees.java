package com.urunov.mongodb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "employees")
public class Employees {

  //  public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String _id;

    private String Name;

    private int Age;

    private String Position;

    private String Phone;

}
