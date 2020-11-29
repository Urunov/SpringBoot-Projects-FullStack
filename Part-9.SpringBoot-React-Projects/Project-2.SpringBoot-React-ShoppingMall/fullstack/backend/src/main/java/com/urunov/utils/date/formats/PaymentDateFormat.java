package com.urunov.utils.date.formats;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
public class PaymentDateFormat extends SimpleDateFormat {

    public PaymentDateFormat()
    {
        super("dd.MM.YYYY HH:mm", new Locale("ru", "RU"));
        DateFormatSymbols russSymbol = new DateFormatSymbols(new Locale("ru", "RU"));
        setDateFormatSymbols(russSymbol);
    }
}
