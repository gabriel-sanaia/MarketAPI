package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Mapper.ReviewMapper;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Model.Review;
import com.example.marketapi.Repository.ReviewRepository;
import com.example.marketapi.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    ReviewMapper reviewMapper = new ReviewMapper();

    @Override
    public ResponseBody postReview(Long productId, ReviewPostDTO dto) {
        Review review = reviewMapper.mapToEntity(dto);

        Product product = new Product();
        product.setId(productId);

        review.setProduct(product);

        ResponseBody responseBody = new ResponseBody();

        try{
            reviewRepository.save(review);
        }catch (Exception ex){
            responseBody.setExceptionText(ex.getMessage());
            responseBody.setStatus("500");

            return responseBody;
        }

        responseBody.setExceptionText("null");
        responseBody.setStatus("OK");

        return responseBody;
    }

    @Override
    public List<ReviewGetDTO> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.getReviewsByProductId(productId);

        return reviewMapper.mapToGetDTOList(reviews);
    }
}
