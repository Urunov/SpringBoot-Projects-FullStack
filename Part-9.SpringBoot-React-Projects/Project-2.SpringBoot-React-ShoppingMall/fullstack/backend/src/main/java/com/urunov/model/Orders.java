package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Orders extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String additionalPhone;

    @NotBlank
    private String address;

    private String name;

    @Lob
    private String comment;

    private Float deliveryPrice;

    private String paymentNumber;

    private String carMark;

    private String carModel;

    private String carColor;

    private String carNumber;

    private String nameDriver;

    private String phoneDriver;

    /**
     * Buy from Online shop;
     * Покупатель (Customer)
     * */

   // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "User", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetailsList;

}
