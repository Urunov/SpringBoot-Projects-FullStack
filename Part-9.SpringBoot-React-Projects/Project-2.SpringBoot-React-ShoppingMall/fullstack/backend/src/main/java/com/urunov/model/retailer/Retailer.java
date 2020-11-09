package com.urunov.model.retailer;

import com.urunov.model.tm.TaxiProperties;
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
@Entity
@Table(name = "retialers")
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование
     * Name
     * */
    @Column(name="name", length = 255, nullable = false)
    private String name;

    /**
     * Логотип
     * Logo-tip
     * */
    @Lob
    private byte[] logo;

    @Transient
    private String imageUrl;

    private String shippingAddress;

    private Boolean isOutdated = false;
    private Long internalCode;

    private List<TaxiProperties> taxiPropertiesList;

    private String city;

    @Column(name = "postion_X", columnDefinition = "decimal(10,8) DEFAULT NULL")
    private Double positionX;

    @Column(name = "position_Y", columnDefinition = "decimal(10, 8) DEFAULT NULL")
    private Double positionY;

    public void RetailerDto(String name, byte[] logo){
        this.name = name;
        this.logo = logo;
    }

}
