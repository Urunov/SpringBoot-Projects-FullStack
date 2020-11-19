package com.urunov.utils;

import org.springframework.stereotype.Component;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Component
public class StringUtils {

    public String removeUseless(String value)
    {
        if(value==null)
            return null;
        String result = value.replaceAll("(\r\n|\n) +", "");
        return result.trim();
    }
}
