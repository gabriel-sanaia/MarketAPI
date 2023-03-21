package com.example.marketapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubCategory {

    @Id
    private int id;

    private String name;

    @ManyToOne
    private Category category;

    private int orderId;
}
