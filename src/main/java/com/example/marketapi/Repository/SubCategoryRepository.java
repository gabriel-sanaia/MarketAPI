package com.example.marketapi.Repository;

import com.example.marketapi.Model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    @Query("SELECT sc FROM SubCategory sc WHERE sc.category.id = :categoryId")
    List<SubCategory> getSubCategoriesByCategoryId(@Param("categoryId") Long categoryId);

}
