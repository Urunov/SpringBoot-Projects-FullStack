//package com.urunov.dao.sql.categories;
//
//import com.urunov.entity.categories.ApparelCategory;
//import org.springframework.data.jpa.repository.JpaRepository;
//
///**
// * User: hamdamboy
// * Project: model
// * Github: @urunov
// */
//public interface ApparelCategoryRepository extends JpaRepository<ApparelCategory, Integer> {
//
////    @Query(value = "SELECT c FROM ApparelImages c where c.apparelCategory.type=?1 and" +
////            " c.genderCategory.type=?2")
////    ApparelCategory findByClothesTypeAndGender(String clothesType, String Gender);
////
////    @Query(value = "SELECT c FROM ApparelCategory c")
////    List<ApparelCategory> getAllData();
//
//    ApparelCategory findByType(String title);
//}
//
