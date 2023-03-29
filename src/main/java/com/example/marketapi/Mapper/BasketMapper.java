package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.BasketDTO;
import com.example.marketapi.DTO.ProductBundleDTO;
import com.example.marketapi.Model.Basket;
import com.example.marketapi.Model.ProductBundle;

import java.util.List;

public class BasketMapper {

    private ProductBundleMapper productBundleMapper = new ProductBundleMapper();

    public BasketDTO mapToDTO(Basket entity) {
        BasketDTO dto = new BasketDTO();
        List<ProductBundle> productBundleList = entity.getProductBundle();
        List<ProductBundleDTO> productBundleDTOList = productBundleMapper.mapToDTOList(productBundleList);
        dto.setProductBundleDTOList(productBundleDTOList);

        return dto;
    }
}
