package com.example.marketapi.Controller;

import com.example.marketapi.DTO.SubCategoryDTO;
import com.example.marketapi.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/subCategories")
    public List<SubCategoryDTO> getAllSubCategories(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        if (categoryId == null){
            return subCategoryService.getAllSubCategories();
        }else {
            return subCategoryService.getSubCategoriesByCategoryId(categoryId);
        }
    }

}
