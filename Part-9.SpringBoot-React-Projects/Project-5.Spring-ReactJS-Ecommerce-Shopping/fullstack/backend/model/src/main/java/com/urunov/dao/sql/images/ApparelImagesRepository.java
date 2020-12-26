package com.urunov.dao.sql.images;

import com.urunov.entity.elements.images.ApparelImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface ApparelImagesRepository extends JpaRepository<ApparelImages, Integer> {

    @Query(value = "SELECT DISTINCT c FROM ApparelImages c")
    List<ApparelImages> getAllData();
}
