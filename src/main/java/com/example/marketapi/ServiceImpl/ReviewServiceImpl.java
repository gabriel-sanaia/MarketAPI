package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Mapper.ReviewMapper;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Model.Review;
import com.example.marketapi.Repository.ProductRepository;
import com.example.marketapi.Repository.ReviewRepository;
import com.example.marketapi.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    ReviewMapper reviewMapper = new ReviewMapper();

    @Override
    public ResponseBody postReview(Long productId, ReviewPostDTO dto) {
        ResponseBody responseBody = new ResponseBody();

        try{
        Review review = reviewMapper.mapToEntity(dto);

        Product product = productRepository.findById(productId).get();


        product.setNewReviewsAvg(dto.getRating());


        review.setProduct(product);


        reviewRepository.save(review);
        productRepository.save(product);
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
