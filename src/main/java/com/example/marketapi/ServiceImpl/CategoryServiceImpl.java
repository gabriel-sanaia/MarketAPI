package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.CategoryDTO;
import com.example.marketapi.Mapper.CategoryMapper;
import com.example.marketapi.Model.Category;
import com.example.marketapi.Repository.CategoryRepository;
import com.example.marketapi.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper = new CategoryMapper();
    @Override
    public List<CategoryDTO> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = categoryMapper.maptoDTOList(categories);

        return categoriesDTO;

    }

//    @Override
//    public CategoryDTO getCategoryById(Long categoryId) {
//        Category category = categoryRepository.findById(categoryId).get();
//
//        return categoryMapper.mapToDTO(category);
//    }
}
