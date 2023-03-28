package com.example.marketapi.Service;

import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Model.ResponseBody;

import java.util.List;

public interface ReviewService {

    ResponseBody postReview(Long productId, ReviewPostDTO dto);

    List<ReviewGetDTO> getReviewsByProductId(Long productId);
}
