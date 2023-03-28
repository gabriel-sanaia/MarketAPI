package com.example.marketapi.ServiceImpl;

import com.example.marketapi.DTO.BrandDTO;
import com.example.marketapi.Mapper.BrandMapper;
import com.example.marketapi.Model.Brand;
import com.example.marketapi.Repository.BrandRepository;
import com.example.marketapi.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    private BrandMapper brandMapper = new BrandMapper();

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();

        List<BrandDTO> brandsDTO = brandMapper.mapToDTOList(brands);

        return brandsDTO;
    }
}
