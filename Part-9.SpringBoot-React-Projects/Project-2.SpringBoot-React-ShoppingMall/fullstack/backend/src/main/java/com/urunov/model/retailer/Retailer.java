package com.urunov.model.retailer;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "retialers")
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Логотип / Logotive
     */
    @Lob
    private byte[] logo;

    @Transient
    private String imageUrl;

    private String shippingAddress;

    private Boolean isOutdated = false;

    private Long internalCode;

    private String city;

    @Column(name = "position_X", columnDefinition = "decimal(10, 8) Default null")
    private Double positionX;

    @Column(name = "position_Y", columnDefinition = "decimal(10, 8) Default null")
    private Double positionY;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "retailer_taxiproperites",
//            joinColumns = @JoinColumn(name = "retailer"),
//            inverseJoinColumns = @JoinColumn(name = "taxiproperty"))
//    private List<TaxiProperties> taxiPropertiesList;
}
