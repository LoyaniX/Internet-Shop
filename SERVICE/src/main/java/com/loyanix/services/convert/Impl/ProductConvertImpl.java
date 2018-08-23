package com.loyanix.services.convert.Impl;

import com.loyanix.DAO.model.Product;
import com.loyanix.services.DTO.ProductDTO;
import com.loyanix.services.convert.ProductConvert;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertImpl implements ProductConvert {

    @Override
    public Product toEntity(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getCatedory(),
                dto.getGender(),
                dto.getColour(),
                dto.getSize(),
                dto.getQuantity());
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getGender(),
                entity.getColour(),
                entity.getSize(),
                entity.getQuantity());
    }
}
