package com.loyanix.DAO.repo.impl;

import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.repo.ProductDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Product product) { entityManager.persist(product); }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Product product) {
        product.setId(id);
        entityManager.merge(product);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT i FROM Product i",Product.class);
        return query.getResultList();
    }

    @Override
    public Product get(Long id) { return entityManager.find(Product.class, id); }

}
