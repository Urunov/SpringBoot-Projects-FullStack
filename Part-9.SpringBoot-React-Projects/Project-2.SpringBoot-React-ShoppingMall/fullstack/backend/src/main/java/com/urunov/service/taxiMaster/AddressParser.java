package com.urunov.service.taxiMaster;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class AddressParser {

    public static Address analyzeAddresses(String query, JSONArray jsonAddress){

        List<Address> addresses = new ArrayList<Address>();
        for(int i=0; i < jsonAddress.size(); i++)
        {
            Address address = new Address((JSONObject) jsonAddress.get(i));
            address.sd = Math.round(StringSimilarity.editDisanceWord(address.getAddr(), query));
            addresses.add(address);
        }
    }
}
