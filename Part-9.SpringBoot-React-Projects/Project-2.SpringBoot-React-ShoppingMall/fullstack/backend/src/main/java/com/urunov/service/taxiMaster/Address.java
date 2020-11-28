package com.urunov.service.taxiMaster;

import org.json.simple.JSONObject;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class Address {

    public String street;
    public String house;
    public Double lat;
    public Double lon;
    public int sd;

    public Address()
    {
        street = "";
        house = "";
        lat = 0.0;
        lon = 0.0;
        sd = 100;
    }

    public Address(JSONObject jsonObject)
    {
        if(jsonObject == null || jsonObject.get("street") == null || jsonObject.get("houese") == null || jsonObject.get("coords") == null)  {
            street = "";
            house = "";
            lat = 0.0;
            lon = 0.0;
            sd = 100;
        }

        street = (String) jsonObject.get("street");
        house = (String) jsonObject.get("house");
        JSONObject coords = (JSONObject) jsonObject.get("coords");
        lat = (Double) coords.get("lat");
        lon = (Double) coords.get("lon");
    }

    public String getAddr(){
        return street + ", " + house;
    }
}
