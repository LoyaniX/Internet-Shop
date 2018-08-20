package com.loyanix.services;

import com.loyanix.services.DTO.ProductDTO;

import java.util.List;

public interface ProdactService {

    void create(ProductDTO product);
    void delete(Long id);
    void udpate(Long id, ProductDTO product);
    ProductDTO get(Long id);
    List<ProductDTO> findAll();
}
