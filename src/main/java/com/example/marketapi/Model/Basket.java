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
    private List<ProductBundle> productBundles;

    public boolean containsProduct(Long productId) {
        for (ProductBundle productBundle : productBundles){
            if(productBundle.getProduct().getId().equals(productId))
                return true;
        }
        return false;
    }

    public Long getProductId(Long productId) {
        for (ProductBundle productBundle : productBundles) {
            if (productBundle.getProduct().getId().equals(productId)) {
                return productBundle.getProduct().getId();
            }
        }
        return 0L;
    }

    public ProductBundle getProductBundle(Long productId) {
        for (ProductBundle productBundle : productBundles) {
            if (productBundle.getProduct().getId().equals(productId)) {
                return productBundle;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductBundle> getProductBundles() {
        return productBundles;
    }

    public void setProductBundles(List<ProductBundle> productBundle) {
        this.productBundles = productBundle;
    }
}
