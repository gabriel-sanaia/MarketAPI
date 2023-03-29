package com.example.marketapi.Repository;

import com.example.marketapi.Model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query(value = "select b from basket b order by b.id desc limit 1", nativeQuery = true)
    Basket getLastBasket();
}
