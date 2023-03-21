package com.example.marketapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Brand {

    @Id
    private Long id;

    private String name;
}
