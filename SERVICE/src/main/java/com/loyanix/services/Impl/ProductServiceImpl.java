package com.loyanix.services.Impl;

import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.repo.ProductDAO;
import com.loyanix.services.DTO.ProductDTO;
import com.loyanix.services.ProdactService;
import com.loyanix.services.convert.ProductConvert;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProdactService {

    private final ProductDAO productDAO;
    private final ProductConvert productConvert;

    public ProductServiceImpl(ProductDAO productDAO, ProductConvert productConvert) {
        this.productDAO = productDAO;
        this.productConvert = productConvert;
    }

    @Override
    public void delete(Long id) {
        productDAO.delete(id);
    }

    @Override
    public void create(ProductDTO product) {
        productDAO.create(productConvert.toEntity(product));
    }

    @Override
    public void udpate(Long id, ProductDTO product) { productDAO.update(id, productConvert.toEntity(product)); }

    @Override
    public ProductDTO get(Long id) {
        productDAO.get(id);
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(productConvert.toDto(product));
        }
        return productDTOS;
    }
}
