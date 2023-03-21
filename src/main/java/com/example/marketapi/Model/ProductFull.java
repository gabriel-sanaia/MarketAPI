package com.example.marketapi.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductFull {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private SubCategory subCategory;
    @ManyToOne
    private Brand brand;
    private String baseDescription;
    private String description;
    @OneToMany
    private List<Review> reviews;
    private int price;
    private int reviewsCount;
    private double reviewsAvg;
    private String pic;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
