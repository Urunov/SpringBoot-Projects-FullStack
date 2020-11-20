package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import com.urunov.model.enumdto.OrderStatus;
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

    @Column(name = "status", columnDefinition = "ENUM('awaitingPayment', 'inProgress', 'paid', 'transferredToDeliveryService', 'completed', 'NEW', 'canceled', 'courierSearch', 'courierFound' ,'deliveryInProgress','awaitingConfirmation', 'delivered') NOT NULL DEFAULT 'inProgress'")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long taxiOrderId;


    /**
     * Buy from Online shop;
     * Покупатель (Customer)
     * */

   // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "User", nullable = false)

  /*  @ManyToOne(cascade = CascadeType.ALL)
    private User user;
*/
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetailsList;

    public Orders(String additionalPhone, @NotBlank String address, String name, String comment, List<Good> goodList, Float  deliveryPrice)
    {
        this.additionalPhone = additionalPhone;
        this.address = address;
        this.name = name;
        this.comment = comment;
        this.deliveryPrice = deliveryPrice;
    }


}
