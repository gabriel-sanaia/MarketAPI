package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.ProductDTO;
import com.example.marketapi.DTO.ProductShortDTO;
import com.example.marketapi.Model.Product;

public class ProductMapper {

    ReviewMapper reviewMapper = new ReviewMapper();

    public ProductDTO mapToFullDTO(Product entity){
        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCategory(entity.getCategory().getName());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setSubCategory(entity.getSubCategory().getName());
        dto.setSubCategoryId(entity.getSubCategory().getId());
        dto.setBrandName(entity.getBrand().getName());
        dto.setBrandId(entity.getBrand().getId());
        dto.setBaseDescription(entity.getBaseDescription());
        dto.setDescription(entity.getDescription());
        dto.setReviews(reviewMapper.mapToGetDTOList(entity.getReviews()));
        dto.setReviewsCount(entity.getReviewsCount());
        dto.setReviewsAvg(entity.getReviewsAvg());
        dto.setPrice(entity.getPrice());
        dto.setPic(entity.getPic());

        return dto;
    }

    public ProductShortDTO mapToShortDTO(Product entity){
        ProductShortDTO dto = new ProductShortDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setSubCategoryId(entity.getSubCategory().getId());
        dto.setBrandId(entity.getBrand().getId());
        dto.setReviewsCount(entity.getReviewsCount());
        dto.setReviewsAvg(entity.getReviewsAvg());
        dto.setPrice(entity.getPrice());
        dto.setPic(entity.getPic());

        return dto;
    }
}
