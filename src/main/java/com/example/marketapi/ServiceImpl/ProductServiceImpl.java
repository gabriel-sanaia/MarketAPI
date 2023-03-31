package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ProductDTO;
import com.example.marketapi.DTO.ProductShortDTO;
import com.example.marketapi.Mapper.ProductMapper;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Repository.ProductRepository;
import com.example.marketapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private ProductMapper productMapper = new ProductMapper();

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).get();
        return productMapper.mapToFullDTO(product);
    }

    @Override
    public List<ProductShortDTO> getProducts(String name, Long brandId, Double priceFrom, Double priceUntil, Double avgRating, Long categoryId, Long subCategoryId, Integer pageNumber, Integer pageSize) {
        List<Product> products = productRepository.getProducts(name, brandId, priceFrom, priceUntil,
                                                                    avgRating, categoryId, subCategoryId);

        List<ProductShortDTO> productShortDTOList = new ArrayList<>();
        for(Product product : products){
            productShortDTOList.add(productMapper.mapToShortDTO(product));
        }

        if(pageNumber != null && pageSize != null) {
            productShortDTOList = productShortDTOList
                    .stream()
                    .skip((pageNumber - 1) * pageSize)
                    .limit(pageSize)
                    .collect(Collectors.toList());
        }
        return productShortDTOList;
    }

}
