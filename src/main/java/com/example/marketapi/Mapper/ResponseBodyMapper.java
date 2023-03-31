package com.example.marketapi.Mapper;

import com.example.marketapi.DTO.ResponseBodyDTO;
import com.example.marketapi.Model.ResponseBody;

public class ResponseBodyMapper {
    public ResponseBodyDTO mapToDTO(ResponseBody responseBody){
        ResponseBodyDTO dto = new ResponseBodyDTO();
        dto.setStatus(responseBody.getStatus());
        dto.setExceptionText(responseBody.getExceptionText());

        return dto;
    }
}
