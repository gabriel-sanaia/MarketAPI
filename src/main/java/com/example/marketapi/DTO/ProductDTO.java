package com.example.marketapi.DTO;

import java.util.List;

public class ProductDTO {
    private String category;
    private String subCategory;
    private String baseDescription;
    private String description;
    private String brandName;
    private List<ReviewGetDTO> reviews;
    private double price;
    private Long brandId;
    private int reviewsCount;
    private double reviewsAvg;
    private Long categoryId;
    private Long subCategoryId;
    private String pic;
    private Long id;
    private String name;


    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public String getBrandName() {
        return brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public String getDescription() {
        return description;
    }

    public List<ReviewGetDTO> getReviews() {
        return reviews;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReviews(List<ReviewGetDTO> reviews) {
        this.reviews = reviews;
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
