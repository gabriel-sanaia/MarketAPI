package com.example.marketapi.Service;

import com.example.marketapi.DTO.FullProductDTO;

public interface ProductService {
    FullProductDTO getProductById(Long productId);
}
