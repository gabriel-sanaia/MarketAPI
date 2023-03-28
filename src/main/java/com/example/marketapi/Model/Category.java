package com.example.marketapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    private int orderId;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
