package com.loyanix.services.convert;

import com.loyanix.DAO.model.Product;
import com.loyanix.services.DTO.ProductDTO;

public interface ProductConvert {
    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}
