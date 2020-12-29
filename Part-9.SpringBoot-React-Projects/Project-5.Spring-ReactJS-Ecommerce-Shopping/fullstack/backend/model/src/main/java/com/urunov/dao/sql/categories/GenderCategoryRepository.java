package com.urunov.dao.sql.categories;

import com.urunov.entity.elements.categories.GenderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface GenderCategoryRepository extends JpaRepository<GenderCategory, Integer> {

    @Query(value = "SELECT g FROM GenderCategory g")
    List<GenderCategory> getAllData();

    GenderCategory findByType(String gender);
}
