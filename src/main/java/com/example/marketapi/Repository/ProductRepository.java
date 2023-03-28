package com.example.marketapi.Repository;

import com.example.marketapi.Model.FullProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<FullProduct, Long> {

@Query(value = "select p from FullProduct p where" +
        "(:name is null or p.name = :name) and" +
        "(:brandId is null or p.brand.id = :brandId) and" +
        "(:priceFrom is null or :priceFrom < p.price) and " +
        "(:priceUntil is null or :priceUntil > p.price) and" +
        "(:avgRating is null or p.reviewsAvg = :avgRating) and" +
        "(:categoryId is null or p.category.id = :categoryId) and" +
        "(:subCategoryId is null or p.subCategory = :subCategory)")
    List<FullProduct> getProducts(@Param("name") String name,
                                  @Param("brandId") Long brandId,
                                  @Param("priceFrom") Double priceFrom,
                                  @Param("priceUntil") Double priceUntil,
                                  @Param("avgRating") Double avgRating,
                                  @Param("categoryId") Long categoryId,
                                  @Param("subCategoryId") Long subCategoryId
                                  );

}


//@Query("select p from FullProduct p where" +
//        "(:name is null or p.name = :name) and" +
//        "(:brandId is null or p.brand.id = :brandId) and" +
//        "(:priceFrom is null or :priceFrom < p.price) and " +
//        "(:priceUntil is null or :priceUntil > p.price) and" +
//        "(:avgRating is null or p.reviewsAvg = :avgRating) and" +
//        "(:categoryId is null or p.category.id = :categoryId) and" +
//        "(:subCategoryId is null or p.subCategory = :subCategory) and" +
//        "(limit :pageSize offset ((:pageNumber - 1 ) * :pageSize))")