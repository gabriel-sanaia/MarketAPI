package com.example.marketapi.DTO;

public class ShortProductDTO {

    private Long id;
    private String name;
    private Long categoryId;
    private Long subCategoryId;
    private Long brandId;
    private int reviewsCount;
    private double reviewsAvg;
    private double price;
    private String pic;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setReviewsAvg(double reviewsAvg) {
        this.reviewsAvg = reviewsAvg;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
