package com.urunov.service.order.payment;

import com.google.gson.Gson;
import com.urunov.payload.payment.PaymentResponse;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */

@Service
public class PaymentService {



    private CKassaApi cKassaApi;

    private String shopToken;

    private String secKey;

    private String servCode;

    DateUtils dateUtils;

    public String registerUser() throws Exception{

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setLogin("799999999");

        return CKassaApi.call("user/registeration", new Gson().toJson(paymentResponse));
    }
}
