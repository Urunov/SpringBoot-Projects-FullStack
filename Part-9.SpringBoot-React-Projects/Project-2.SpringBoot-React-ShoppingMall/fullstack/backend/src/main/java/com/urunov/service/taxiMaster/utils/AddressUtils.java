package com.urunov.service.taxiMaster.utils;

import org.springframework.stereotype.Service;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class AddressUtils {

    public String cleanAddress(String address, String city){

        // String pattern1

        String pattern1 = "�*\\.*\\s*" + city + ",*"; //
        String pattern2 = "\\s*" + city + ",*"; //

        return address
                .trim()
                .replaceAll(pattern1, "")
                .replaceAll(pattern2, "")
                .trim();
    }

}
