package com.urunov.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "employees")
public class Employees {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;

    private String Name;

    private int Age;

    private String Position;

    private String Phone;

}
