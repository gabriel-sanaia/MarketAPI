package com.example.marketapi.Controller;

import com.example.marketapi.DTO.ProductDTO;
import com.example.marketapi.DTO.ReviewPostDTO;
import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Service.ProductService;
import com.example.marketapi.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long productId) {
        try {
            ProductDTO dto = productService.getProductById(productId);
            return ResponseEntity.ok(dto);
        } catch (IllegalParameterException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping("/products")
    public ResponseEntity getProducts(@RequestParam(name = "name", required = false) String name,
                                      @RequestParam(name = "brandId", required = false) Long brandId,
                                      @RequestParam(name = "priceFrom", required = false) Double priceFrom,
                                      @RequestParam(name = "priceUntil", required = false) Double priceUntil,
                                      @RequestParam(name = "avgRating", required = false) Double avgRating,
                                      @RequestParam(name = "categoryId", required = false) Long categoryId,
                                      @RequestParam(name = "subCategoryId", required = false) Long subCategoryId,
                                      @RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                                      @RequestParam(name = "pageSize", required = false) Integer pageSize){

        try {
            return ResponseEntity.ok(productService.getProducts(
                    name, brandId, priceFrom, priceUntil, avgRating, categoryId, subCategoryId, pageNumber, pageSize));

        } catch (IllegalParameterException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()); //
        }
}

    @PostMapping("/product/{productId}/postReview")
    public ResponseEntity postReview(@PathVariable Long productId, @RequestBody ReviewPostDTO reviewPostDTO) {
        try {
            return ResponseEntity.ok(reviewService.postReview(productId, reviewPostDTO));
        }catch (IllegalParameterException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/product/{productId}/getReviews")
    public ResponseEntity getReviewsByProductId(@PathVariable Long productId){
        try {
            return ResponseEntity.ok(reviewService.getReviewsByProductId(productId));

        }catch (IllegalParameterException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
