package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import com.urunov.model.enumdto.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Orders extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String email;
    private String additionalPhone;
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
    private String phoneDriver;

    @Column(name = "status", columnDefinition = "ENUM('awaitingPayment', 'inProgress', 'paid', 'transferredToDeliveryService', 'completed', 'NEW', 'canceled', 'courierSearch', 'courierFound' ,'deliveryInProgress','awaitingConfirmation', 'delivered') NOT NULL DEFAULT 'inProgress'")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long taxiOrderId;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetailsList;

}
