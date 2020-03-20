package entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "item")
@NoArgsConstructor


public class Product {
    //

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;

}
