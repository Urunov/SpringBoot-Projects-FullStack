package com.urunov.model;

import com.urunov.model.audit.DateAudit;
import com.urunov.model.retailer.Retailer;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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
@ToString
@Entity
public class Good extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String internalCode;

    private String name;

    private BigDecimal currentPrice;

    @Transient
    private String imageUrl;

    @Transient
    private Boolean isAddToBucket;

    @Lob
    private byte[] image;

    @Lob
    @Column
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "retailers_id")
    private Retailer retailer;


}
