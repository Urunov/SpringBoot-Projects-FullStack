package com.urunov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    @JsonIgnore
    private String ImageUrl;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    /**Number of good, Количество товара*/
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "good_id", nullable = false)
    private Good good;

}
