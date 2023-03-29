package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.DTO.ProductShortDTO;
import com.example.marketapi.Model.Product;
import com.example.marketapi.Model.ProductBundle;
import com.example.marketapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ProductBundleMapper {

    ProductMapper productMapper = new ProductMapper();

    public ProductBundleDTO mapToDTO(ProductBundle entity){
        ProductBundleDTO dto = new ProductBundleDTO();

        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        Double price = entity.getProduct().getPrice() * entity.getQuantity();
        dto.setPrice(price);
        ProductShortDTO productShortDTO = productMapper.mapToShortDTO(entity.getProduct());
        dto.setShortProduct(productShortDTO);

        return dto;

    }

    public List<ProductBundleDTO> mapToDTOList(List<ProductBundle> productBundleList){
        List<ProductBundleDTO> dtoList = new ArrayList<>();

        for(ProductBundle productBundle : productBundleList){
            dtoList.add(mapToDTO(productBundle));
        }
        return dtoList;
    }

}
