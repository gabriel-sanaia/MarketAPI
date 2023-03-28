package com.example.marketapi.DTO;

public class CategoryDTO {
    private Long id;

    private String name;

    private int orderId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrderId() {
        return orderId;
    }
}
