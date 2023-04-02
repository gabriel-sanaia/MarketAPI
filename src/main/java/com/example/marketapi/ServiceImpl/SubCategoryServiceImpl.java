package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.SubCategoryDTO;
import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Mapper.SubCategoryMapper;
import com.example.marketapi.Model.SubCategory;
import com.example.marketapi.Repository.SubCategoryRepository;
import com.example.marketapi.Service.CategoryService;
import com.example.marketapi.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    SubCategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    private SubCategoryMapper subCategoryMapper = new SubCategoryMapper();

    @Override
    public List<SubCategoryDTO> getAllSubCategories() {

            List<SubCategory> subCategories = categoryRepository.findAll();
            List<SubCategoryDTO> subCategoriesDTO = subCategoryMapper.mapToDTOList(subCategories);

            return subCategoriesDTO;
    }

    @Override
    public List<SubCategoryDTO> getSubCategoriesByCategoryId(Long categoryId) throws IllegalParameterException{

        if(!categoryRepository.existsById(categoryId)){
            throw new IllegalParameterException("No category exists with this id");
        }

        List<SubCategory> subCategories = categoryRepository.getSubCategoriesByCategoryId(categoryId);

        return subCategoryMapper.mapToDTOList(subCategories);
    }
}
