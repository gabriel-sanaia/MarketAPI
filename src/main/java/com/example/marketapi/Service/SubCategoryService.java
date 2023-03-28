package com.example.marketapi.Service;

import com.example.marketapi.DTO.SubCategoryDTO;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryDTO> getAllSubCategories();

    List<SubCategoryDTO> getSubCategoriesByCategoryId(Long categoryId);
}
