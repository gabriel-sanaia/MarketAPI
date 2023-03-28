package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.FullProductDTO;
import com.example.marketapi.Mapper.ProductMapper;
import com.example.marketapi.Model.FullProduct;
import com.example.marketapi.Repository.ProductRepository;
import com.example.marketapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private ProductMapper productMapper = new ProductMapper();

    @Override
    public FullProductDTO getProductById(Long productId) {
        FullProduct product = productRepository.findById(productId).get();
        return productMapper.mapToFullDTO(product);
    }

}
