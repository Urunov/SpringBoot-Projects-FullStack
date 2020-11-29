package com.urunov.utils;

import com.urunov.utils.date.formats.PaymentDateFormat;
import com.urunov.utils.date.formats.RussianDateFormat;
import org.springframework.stereotype.Component;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Component
public class DateFormats {

    private static final RussianDateFormat RussianDateFormat = new RussianDateFormat();

    private static final PaymentDateFormat PaymentDateFormat = new PaymentDateFormat();

    public com.urunov.utils.date.formats.RussianDateFormat getRussianFormat()
    {
        return RussianDateFormat;
    }

    public com.urunov.utils.date.formats.PaymentDateFormat getPaymentDateFormat()
    {
        return PaymentDateFormat;
    }
}
