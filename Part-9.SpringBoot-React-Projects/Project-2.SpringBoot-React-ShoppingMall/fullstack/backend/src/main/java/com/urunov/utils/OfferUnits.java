package com.urunov.utils;

import com.urunov.model.Offer;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
public class OfferUnits {

    public void initOfferImages(List<Offer> offerList)
    {
        for (Offer offer : offerList)
        {
            if (offer.getImage() != null)
                offer.setImageUrl(new String(Base64.decodeBase64(offer.getImage()), StandardCharsets.UTF_8));
        }
    }
}
