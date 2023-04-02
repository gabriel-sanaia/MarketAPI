package com.example.marketapi.Controller;

import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/subCategories")
    public ResponseEntity getAllSubCategories(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        if (categoryId == null){
            return ResponseEntity.ok(subCategoryService.getAllSubCategories());

        }else {
            try {
                return ResponseEntity.ok(subCategoryService.getSubCategoriesByCategoryId(categoryId));

            }catch (IllegalParameterException ex){
                return ResponseEntity.badRequest().body(ex.getMessage());
            }
        }
    }
}
