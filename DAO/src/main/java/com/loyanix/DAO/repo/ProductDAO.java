package com.loyanix.DAO.repo;

import com.loyanix.DAO.model.Product;

import java.util.List;

public interface ProductDAO {

    void create(Product product);
    void delete (Long id);
    Product get(Long id);
    void update(Long id, Product product);
    List<Product> findAll();
}
