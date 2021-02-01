//package com.urunov.dao.sql.images;
//
//import com.urunov.entity.images.BrandImages;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
///**
// * User: hamdamboy
// * Project: model
// * Github: @urunov
// */
//public interface BrandImagesRepository extends JpaRepository<BrandImages, Integer> {
//
//    @Query(value = "SELECT DISTINCT b FROM BrandImages b")
//    List<BrandImages> getAllData();
//}
