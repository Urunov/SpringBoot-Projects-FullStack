package com.urunov.dao.sql.categories;

import com.urunov.entity.elements.categories.SortByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface SortByCategoryRepository extends JpaRepository<SortByCategory, Integer> {

    @Query(value = "SELECT s FROM SortByCategoty s")
    List<SortByCategory> getAllData();

    SortByCategory findByType(String type);

}
