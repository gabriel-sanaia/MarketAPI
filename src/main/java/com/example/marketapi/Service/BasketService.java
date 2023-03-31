package com.example.marketapi.Service;

import com.example.marketapi.DTO.BasketDTO;
import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.Model.ProductBundle;
import com.example.marketapi.Model.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BasketService {
    List<ProductBundleDTO> getBasket();

    ResponseBodyDTO addProductToBasket(Long productId, Integer quantity);

    ResponseBodyDTO deleteProductFromBasket(Long productId);

    ResponseBodyDTO updateProductsQuantity(Integer quantity, Long productId);

}
