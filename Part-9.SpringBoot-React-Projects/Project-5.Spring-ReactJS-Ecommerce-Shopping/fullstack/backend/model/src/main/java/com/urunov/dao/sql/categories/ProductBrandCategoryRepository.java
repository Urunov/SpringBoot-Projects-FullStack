package com.urunov.dao.sql.categories;

import com.urunov.entity.elements.categories.ProductBrandCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface ProductBrandCategoryRepository extends JpaRepository<ProductBrandCategory, Integer> {

        @Query(value = "SELECT p from ProductBrandCategory p")
        List<ProductBrandCategory> getAllData();

        ProductBrandCategory findByType(String brandName);
}
