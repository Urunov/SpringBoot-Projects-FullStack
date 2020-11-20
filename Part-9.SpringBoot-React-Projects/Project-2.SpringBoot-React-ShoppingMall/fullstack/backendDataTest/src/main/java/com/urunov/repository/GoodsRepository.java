package com.urunov.repository;

import com.urunov.model.Good;
import com.urunov.model.retailer.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Repository
public interface GoodsRepository extends JpaRepository<Good, Long> {

    Good findGoodById(Long id);


    List<Good> findByInternalCodeAndIsOutdated(String id, Boolean isOutdated);

    List<Good> findByInternalCodeAndRetailer(String id, Retailer retailer);

    Page<Good> findGoodByRetailerAndIsOutdated(Retailer retailer, Boolean isOutdated, Pageable pageable);

    List<Good> findAllByInternalCodeAndIsOutdated(String id, Boolean isOutdated);

    Page<Good> findByIsOutdated(Boolean isOutdated, Pageable pageable);

    List<Good> findByIsOutdated(Boolean isOutdated);

}
