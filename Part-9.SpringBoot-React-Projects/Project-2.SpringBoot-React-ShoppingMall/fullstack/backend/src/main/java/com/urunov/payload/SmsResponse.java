package com.urunov.payload;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsResponse {

    @NotBlank
    private String phone;

    private String smsCode;


}
