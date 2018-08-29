package com.loyanix.services.Impl;

import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.repo.ProductDAO;
import com.loyanix.services.DTO.ProductDTO;
import com.loyanix.services.ProductService;
import com.loyanix.services.convert.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;
    private final ProductConvert productConvert;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, ProductConvert productConvert) {
        this.productDAO = productDAO;
        this.productConvert = productConvert;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        productDAO.delete(id);
    }

    @Transactional
    @Override
    public void create(ProductDTO product) {
        productDAO.create(productConvert.toEntity(product));
    }

    @Transactional
    @Override
    public void udpate(Long id, ProductDTO product) { productDAO.update(id, productConvert.toEntity(product)); }

    @Transactional(readOnly = true)
    @Override
    public ProductDTO get(Long id) {
        return productConvert.toDto(productDAO.get(id));
    }

    @Transactional(readOnly = true)
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
