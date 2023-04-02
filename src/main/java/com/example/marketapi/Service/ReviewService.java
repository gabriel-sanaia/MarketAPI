package com.example.marketapi.Service;

import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Exception.IllegalParameterException;

import java.util.List;

public interface ReviewService {

    ResponseBodyDTO postReview(Long productId, ReviewPostDTO dto) throws IllegalParameterException;

    List<ReviewGetDTO> getReviewsByProductId(Long productId) throws IllegalParameterException;
}
