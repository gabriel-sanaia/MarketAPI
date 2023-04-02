package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.ProductDTO;
import com.example.marketapi.DTO.ProductShortDTO;
import com.example.marketapi.Exception.IllegalParameterException;
import com.example.marketapi.Mapper.ProductMapper;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Repository.BrandRepository;
import com.example.marketapi.Repository.CategoryRepository;
import com.example.marketapi.Repository.ProductRepository;
import com.example.marketapi.Repository.SubCategoryRepository;
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

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    private ProductMapper productMapper = new ProductMapper();

    @Override
    public ProductDTO getProductById(Long productId) throws IllegalParameterException {
        if(productRepository.existsById(productId)){
            Product product = productRepository.findById(productId).get();
            return productMapper.mapToFullDTO(product);
        }else {
            throw new IllegalParameterException("Provided Illegal ID");
        }
    }

    @Override
    public List<ProductShortDTO> getProducts(String name, Long brandId, Double priceFrom, Double priceUntil, Double avgRating, Long categoryId,
                                             Long subCategoryId, Integer pageNumber, Integer pageSize) throws IllegalParameterException {

        checkParametersExistence(name, brandId, categoryId, subCategoryId);

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

    private void checkParametersExistence(String name, Long brandId, Long categoryId, Long subCategoryId) throws IllegalParameterException {
        if(name != null && !productRepository.existsByName(name))
            throw new IllegalParameterException("No product exists with this name");

        if(brandId != null && !brandRepository.existsById(brandId))
            throw new IllegalParameterException("No brand exists with this id");

        if(categoryId != null && !categoryRepository.existsById(categoryId))
            throw new IllegalParameterException("No category exists with this id");

        if(subCategoryId != null && !subCategoryRepository.existsById(subCategoryId))
            throw new IllegalParameterException("No subcategory exists with this id");
    }

}
