package com.example.marketapi.DTO;

import java.util.List;

public class BasketDTO {
    private List<ProductBundleDTO> productBundleDTOList;

    public List<ProductBundleDTO> getProductBundleDTOList() {
        return productBundleDTOList;
    }

    public void setProductBundleDTOList(List<ProductBundleDTO> productBundleDTOList) {
        this.productBundleDTOList = productBundleDTOList;
    }
}
