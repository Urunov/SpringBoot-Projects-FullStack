package com.urunov.repository;

import com.urunov.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public interface OfferRepository extends JpaRepository<Offer, Long>
{
    Offer findOfferById(Long id);
}
