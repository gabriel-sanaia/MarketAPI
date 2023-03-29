package com.example.marketapi.DTO;

public class ProductBundleDTO {
    private Long id;
    private Integer quantity;
    private Double price;
    private ProductShortDTO shortProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductShortDTO getShortProduct() {
        return shortProduct;
    }

    public void setShortProduct(ProductShortDTO shortProduct) {
        this.shortProduct = shortProduct;
    }
}
