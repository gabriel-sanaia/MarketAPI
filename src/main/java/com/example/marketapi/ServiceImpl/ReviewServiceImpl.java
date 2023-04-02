package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Mapper.ReviewMapper;
import com.example.marketapi.Model.Product;
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
    public ResponseBodyDTO postReview(Long productId, ReviewPostDTO dto) {

        try {
            checkProductExistence(productId);
            if(dto.getUserName() == null || dto.getRating() == null || dto.getComment() == null)
                throw new IllegalParameterException("Provided information is not sufficient");

            Review review = reviewMapper.mapToEntity(dto);
            Product product = productRepository.findById(productId).get();
            product.setNewReviewsAvg(dto.getRating());

            review.setProduct(product);
            reviewRepository.save(review);
            productRepository.save(product);

        }catch (IllegalParameterException ex) {
            return new ResponseBodyDTO("400", ex.getMessage());

        }catch (Exception ex){
            return new ResponseBodyDTO("500", ex.getMessage());
        }
        return new ResponseBodyDTO("null", "OK");
    }

    @Override
    public List<ReviewGetDTO> getReviewsByProductId(Long productId) throws IllegalParameterException {
        checkProductExistence(productId); //

        List<Review> reviews = reviewRepository.getReviewsByProductId(productId);

        return reviewMapper.mapToGetDTOList(reviews);
    }

    private void checkProductExistence(Long productId) throws IllegalParameterException {
        if (!productRepository.existsById(productId))
            throw new IllegalParameterException("Provided Illegal product ID");
    }
}
