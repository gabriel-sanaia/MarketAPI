package com.example.marketapi.Controller;

import com.example.marketapi.DTO.BrandDTO;
import com.example.marketapi.Model.Brand;
import com.example.marketapi.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/brands")
    public List<BrandDTO> getBrands(){

        return brandService.getAllBrands();
    }
}
