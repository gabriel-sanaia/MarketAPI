package com.example.marketapi.Repository;

import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.product.id = :productId")
    List<Review> getReviewsByProductId(@Param("productId") Long productId);

}
