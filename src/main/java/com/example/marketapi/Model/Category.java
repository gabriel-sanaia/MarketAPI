package com.example.marketapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    private int orderId;
}
