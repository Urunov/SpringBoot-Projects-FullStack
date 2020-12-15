package com.urunov.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User: hamdamboy
 * Project: card
 * Github: @urunov
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {

    private static final long serialVersionUID = 6705527563808382509L;

    // Id of the product
    private Long id;

    // name of the product
    private String name;

    private BigDecimal price;

    private Integer quantity;


    @Override
    public boolean equals(Object that){
        if(this == that) return true;

        if(!(that instanceof Product)) return false;

        Product product = (Product) that;

        return this.id != null && this.id.equals(product.id);
    }
}
