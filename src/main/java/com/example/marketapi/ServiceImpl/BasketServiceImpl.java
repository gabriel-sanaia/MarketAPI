package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.BasketDTO;
import com.example.marketapi.Repository.BasketRepository;
import com.example.marketapi.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;


    @Override
    public BasketDTO getBasket() {
        return null;
    }
}
