package com.example.marketapi.DTO;

public class ProductShortDTO {
    private double price;
    private Long brandId;
    private int reviewsCount;
    private double reviewsAvg;
    private Long categoryId;
    private Long subCategoryId;
    private String pic;
    private Long id;
    private String name;


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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public double getReviewsAvg() {
        return reviewsAvg;
    }

    public double getPrice() {
        return price;
    }

    public String getPic() {
        return pic;
    }
}
