package com.urunov.utils.date.formats;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
public class RussianDateFormat extends SimpleDateFormat {

    private static final long serialVersionUID = 3578411123793165937L;

    public RussianDateFormat()
    {
        super("YYYYMMddhhmmss", new Locale("ru", "RU"));
        DateFormatSymbols russSymbol = new DateFormatSymbols(new Locale("ru", "RU"));
        setDateFormatSymbols(russSymbol);
    }
}
