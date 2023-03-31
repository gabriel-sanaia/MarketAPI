package com.example.marketapi.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String baseDescription;
    private String description;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
    private double price;
    private int reviewsCount;
    private double reviewsAvg;
    private String pic;

    public Product(String name) {
        this.name = name;
    }

    public Product() {

    }

    public void setNewReviewsAvg(Integer rating){
        Double oldAvg = reviewsCount * reviewsAvg;
        reviewsAvg = (oldAvg + rating) / (reviewsCount + 1);
        reviewsCount++;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public String getDescription() {
        return description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public double getPrice() {
        return price;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public double getReviewsAvg() {
        return reviewsAvg;
    }

    public String getPic() {
        return pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setReviewsAvg(double reviewsAvg) {
        this.reviewsAvg = reviewsAvg;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
