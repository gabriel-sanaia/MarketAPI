package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {

    public ReviewGetDTO mapToGetDTO(Review entity){
        ReviewGetDTO dto = new ReviewGetDTO();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setProductId(entity.getProduct().getId());
        dto.setRating(entity.getRating());
        dto.setComment(entity.getComment());

        return dto;
    }

    public List<ReviewGetDTO> mapToGetDTOList(List<Review> reviews){
        List<ReviewGetDTO> dtoList = new ArrayList<>();

        for (Review review : reviews){
            dtoList.add(mapToGetDTO(review));
        }
        return dtoList;
    }

    public Review mapToEntity(ReviewPostDTO dto) {
        Review entity = new Review();

        entity.setUsername(dto.getUserName());
        entity.setRating(dto.getRating());
        entity.setComment(dto.getComment());

        return entity;
    }
}
