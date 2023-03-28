package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.BrandDTO;
import com.example.marketapi.Model.Brand;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {
    public BrandDTO mapToDTO(Brand entity){
        BrandDTO dto = new BrandDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public List<BrandDTO> mapToDTOList(List<Brand> brands){
        List<BrandDTO> dtoList = new ArrayList<>();

        for(Brand brand: brands) {
            dtoList.add(mapToDTO(brand));
        }

        return dtoList;
    }
}
