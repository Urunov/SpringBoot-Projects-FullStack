package model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "ticket")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Ticket {
    //
    @Id
    @GeneratedValue
    private int id;

//    @Column(name = "amount", nullable = false, length = 322)
    private double amount;
    private String category;

}
