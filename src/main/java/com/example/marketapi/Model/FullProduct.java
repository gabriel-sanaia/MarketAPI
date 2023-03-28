package com.example.marketapi.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class FullProduct {

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

    public FullProduct(String name) {
        this.name = name;
    }

    public FullProduct() {

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
}
