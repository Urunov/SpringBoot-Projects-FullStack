package com.urunov.controller.web.vo;

import lombok.*;

import java.io.Serializable;

/**
 * User: hamdamboy
 * Project: card
 * Github: @urunov
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemRequest implements Serializable {

    private static final long serialVersionUID = 7720978167137384733L;

    private Long id;

    private Integer quantity;
}
