package com.example.marketapi.Controller;

import com.example.marketapi.Model.Category;
import com.example.marketapi.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.marketapi.DTO.CategoryDTO;

@RestController
@RequestMapping("/rest")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> getCategories(){
        return categoryService.getAllCategories();
    }

}
