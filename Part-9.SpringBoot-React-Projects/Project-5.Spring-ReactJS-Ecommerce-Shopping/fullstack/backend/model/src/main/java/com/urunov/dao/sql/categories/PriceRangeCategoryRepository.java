package com.urunov.dao.sql.categories;

import com.urunov.entity.elements.categories.GenderCategory;
import com.urunov.entity.elements.categories.PriceRangeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface PriceRangeCategoryRepository extends JpaRepository<PriceRangeCategory, Integer> {

    @Query(value = "SELECT g from GenderCategory g")
    List<GenderCategory> getAllData();

    PriceRangeCategory findByType(String type);
}
