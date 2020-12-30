//package com.urunov.dao.sql.images;
//
//import com.urunov.entity.elements.images.CarouselImages;
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
//public interface CarouselImagesRepository extends JpaRepository<CarouselImages, Integer> {
//
//    @Query(value = "SELECT DISTINCT c FROM CarouselImages c")
//    List<CarouselImages> getAllData();
//}
