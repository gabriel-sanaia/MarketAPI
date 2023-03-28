package com.example.marketapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private int orderId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
