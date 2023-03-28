package com.example.marketapi.Controller;

import com.example.marketapi.DTO.FullProductDTO;
import com.example.marketapi.DTO.ReviewGetDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Model.ResponseBody;
import com.example.marketapi.Service.ProductService;
import com.example.marketapi.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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



    @PostMapping("/product/{productId}/postReview")
    public ResponseBody postReview(@PathVariable Long productId, @RequestBody ReviewPostDTO reviewPostDTO) {
        return reviewService.postReview(productId, reviewPostDTO);
    }

    @GetMapping("/product/{productId}/getReviews")
    public List<ReviewGetDTO> getReviewsByProductId(@PathVariable Long productId){

        return reviewService.getReviewsByProductId(productId);
    }

}
