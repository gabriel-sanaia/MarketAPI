package com.example.marketapi.Service;

import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.DTO.ResponseBodyDTO;

import java.util.List;

public interface BasketService {
    List<ProductBundleDTO> getBasket();

    ResponseBodyDTO addProductToBasket(Long productId, Integer quantity);

    ResponseBodyDTO deleteProductFromBasket(Long productId);

    ResponseBodyDTO updateProductsQuantity(Integer quantity, Long productId);

}
