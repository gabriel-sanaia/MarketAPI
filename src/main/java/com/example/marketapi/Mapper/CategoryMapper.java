package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.CategoryDTO;
import com.example.marketapi.Model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public CategoryDTO mapToDTO(Category entity) {
        CategoryDTO dto = new CategoryDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setOrderId(entity.getOrderId());

        return dto;
    }


    public List<CategoryDTO> maptoDTOList(List<Category> categories) {
        List<CategoryDTO> dtoList = new ArrayList<>();

        for (Category category : categories){
            dtoList.add(mapToDTO(category));
        }

        return dtoList;
    }
}
