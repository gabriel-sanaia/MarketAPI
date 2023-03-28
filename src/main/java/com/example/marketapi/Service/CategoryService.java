package com.example.marketapi.Service;

import com.example.marketapi.DTO.CategoryDTO;
import com.example.marketapi.Model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

//    CategoryDTO getCategoryById(Long categoryId);
}
