package com.urunov.repository;

import com.urunov.model.retailer.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {

    Optional<Retailer> findByInternalCode(Long internalCode);

    Page<Retailer> findAllByIsOutdated(Pageable pageable, Boolean isOutdated);

    Page<Retailer> findFirstByIsOutdated(Pageable pageable, Boolean isOutdated);

    Page<Retailer> findAllByIsOutdatedAndCity(Boolean usOutdated, String city, Pageable pageable);

    List<Retailer> findDistinctByIsOutdated(Boolean isOutdated);
}
