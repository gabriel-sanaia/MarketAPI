package com.example.marketapi.Model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @TableGenerator(name = "seq_reviews",
            table = "seq_market", schema = "public", pkColumnName = "gen_key",
            valueColumnName = "next_val", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_reviews") //// FIXME: 28.03.2023
    @Column(name = "id")
    private Long id;
    private String username;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int rating;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
