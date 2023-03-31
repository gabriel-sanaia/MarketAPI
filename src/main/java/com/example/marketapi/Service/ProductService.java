package com.example.marketapi.Service;

import com.example.marketapi.DTO.ProductDTO;
import com.example.marketapi.DTO.ProductShortDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long productId);

    List<ProductShortDTO> getProducts(String name,
                                      Long brandId,
                                      Double priceFrom,
                                      Double priceUntil,
                                      Double avgRating,
                                      Long categoryId,
                                      Long subCategoryId,
                                      Integer pageNumber,
                                      Integer pageSize );
}
