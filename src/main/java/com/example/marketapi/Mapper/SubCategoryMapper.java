package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.SubCategoryDTO;
import com.example.marketapi.Model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryMapper {

    public SubCategoryDTO mapToDTO(SubCategory entity) {
        SubCategoryDTO dto = new SubCategoryDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setOrderId(entity.getOrderId());

        return dto;
    }

    public List<SubCategoryDTO> mapToDTOList(List<SubCategory> subCategories){
        List<SubCategoryDTO> dtoList = new ArrayList<>();

        for(SubCategory subCategory : subCategories) {
            dtoList.add(mapToDTO(subCategory));
        }

        return dtoList;
    }
}
