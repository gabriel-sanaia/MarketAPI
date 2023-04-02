package com.example.marketapi.Controller;

import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("/getBasket")
    public List<ProductBundleDTO> getBasket(){
        return basketService.getBasket();
    }

    @PostMapping("/addToBasket")
    public ResponseBodyDTO addProductToBasket(@RequestParam Long productId, @RequestParam Integer quantity){
        return basketService.addProductToBasket(productId, quantity);
    }

    @DeleteMapping("/basket/{id}/remove")
    public ResponseBodyDTO deleteProductFromBasket(@PathVariable("id") Long productId){
        return basketService.deleteProductFromBasket(productId);
    }

    @PutMapping("/basket/{id}/update")
    public ResponseBodyDTO updateProductsQuantity(@RequestParam Integer quantity, @PathVariable("id") Long productId){
        return basketService.updateProductsQuantity(quantity, productId);
    }
}
