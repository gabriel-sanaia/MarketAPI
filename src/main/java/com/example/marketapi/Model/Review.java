package com.example.marketapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    private Long id;
    private String username;
    @ManyToOne
    private ProductFull productId;
    private int rating;
    private String comment;


}
