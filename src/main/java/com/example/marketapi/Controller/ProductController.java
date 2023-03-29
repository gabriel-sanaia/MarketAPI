package com.example.marketapi.Controller;

import com.example.marketapi.DTO.FullProductDTO;
import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.DTO.ProductShortDTO;
import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Service.ProductService;
import com.example.marketapi.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/product/{id}")
    public FullProductDTO getProductById(@PathVariable("id") Long productId){
        FullProductDTO dto = productService.getProductById(productId);
       return dto;
    }

    @GetMapping("/products")
    public List<ProductShortDTO> getProducts(@RequestParam(name = "name", required = false) String name,
                                             @RequestParam(name = "brandId", required = false) Long brandId,
                                             @RequestParam(name = "priceFrom", required = false) Double priceFrom,
                                             @RequestParam(name = "priceUntil", required = false) Double priceUntil,
                                             @RequestParam(name = "avgRating", required = false) Double avgRating,
                                             @RequestParam(name = "categoryId", required = false) Long categoryId,
                                             @RequestParam(name = "subCategoryId", required = false) Long subCategoryId,
                                             @RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                                             @RequestParam(name = "pageSize", required = false) Integer pageSize
    ){
        return productService.getProducts(name, brandId, priceFrom, priceUntil, avgRating, categoryId, subCategoryId, pageNumber, pageSize);
    }

    @PostMapping("/product/{productId}/postReview")
    public ResponseBody postReview(@PathVariable Long productId, @RequestBody ReviewPostDTO reviewPostDTO) {
        return reviewService.postReview(productId, reviewPostDTO);
    }

    @GetMapping("/product/{productId}/getReviews")
    public List<ReviewGetDTO> getReviewsByProductId(@PathVariable Long productId){

        return reviewService.getReviewsByProductId(productId);
    }

}
