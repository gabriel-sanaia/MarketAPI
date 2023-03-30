package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.BasketDTO;
import com.example.marketapi.Mapper.BasketMapper;
import com.example.marketapi.Model.Basket;
import com.example.marketapi.Repository.BasketRepository;
import com.example.marketapi.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository basketRepository;

    private BasketMapper basketMapper = new BasketMapper();

    @Override
    public BasketDTO getBasket() {
        Basket basket = basketRepository.getLastBasket();
        BasketDTO dto = basketMapper.mapToDTO(basket);

        return dto;
    }

}
