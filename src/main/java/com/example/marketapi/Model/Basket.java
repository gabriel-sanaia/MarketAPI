package com.example.marketapi.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {

    @Id
    @TableGenerator(name = "seq_baskets", table = "seq_market", schema = "public",
                    pkColumnName = "gen_key", valueColumnName = "next_val", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_baskets")
    private Long id;

    @OneToMany(mappedBy = "basket")
    private List<ProductBundle> productBundle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductBundle> getProductBundle() {
        return productBundle;
    }

    public void setProductBundle(List<ProductBundle> productBundle) {
        this.productBundle = productBundle;
    }
}
