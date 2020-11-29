package com.urunov.service.taxiMaster;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class AddressParser {

    public static Address analyzeAddresses(String query, JSONArray jsonAddresses){

        List<Address> addresses = new ArrayList<Address>();
        for(int i=0; i < jsonAddresses.size(); i++)
        {
            Address address = new Address((JSONObject)jsonAddresses.get(i));
            address.sd = (int)Math.round(StringSimilarity.editDistanceWord(address.getAddr(), query));
            addresses.add(address);
        }

        List<Address> cleanAddresses = new ArrayList<Address>();
        for(Address a : addresses)
            if(a.sd < 55 && a.lon != 0.0d && a.lat != 0.0d)
                cleanAddresses.add(a);
        Collections.sort(cleanAddresses, new StringSimilarity<Address>(query));


        List<Address> newAddresses = new ArrayList<Address>();
        if(cleanAddresses.size() > 0)
        {
            newAddresses.add(cleanAddresses.get(0));
            for(int i = 1; i < cleanAddresses.size(); i++)
            {
                boolean b = false;
                for(int j = 0; j < newAddresses.size(); j++)
                {
                    Double lat = cleanAddresses.get(i).lat;
                    Double lon = cleanAddresses.get(i).lon;
                    Double alat = newAddresses.get(j).lat;
                    Double alon = newAddresses.get(j).lon;
                    if((lat - alat <= 0.001) && (lon - alon <= 0.001))
                    {
                        cleanAddresses.get(i).lat = (alat + lat) / 2;
                        cleanAddresses.get(i).lon = (alon + lon) / 2;
                        b = true;
                        break;
                    }
                }
                if(!b)
                    newAddresses.add(cleanAddresses.get(i));
            }
        }
        if(newAddresses.size() > 0)
            return newAddresses.get(0);
        else
            return null;
    }
}
