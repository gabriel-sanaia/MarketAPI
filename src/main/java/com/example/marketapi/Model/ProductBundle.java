package com.example.marketapi.Model;

import jakarta.persistence.*;

@Entity
public class ProductBundle {
    @Id
    @TableGenerator(name = "seq_productBundles",
                    table = "seq_market", schema = "public",
                    pkColumnName = "gen_key", pkColumnValue = "gen_value")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_productBundles")
    private Long id;
    private Integer quantity;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @JoinColumn(name = "basket_id")
    @ManyToOne
    private Basket basket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
