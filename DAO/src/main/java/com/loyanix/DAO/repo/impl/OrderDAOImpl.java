package com.loyanix.DAO.repo.impl;

import com.loyanix.DAO.model.Order;
import com.loyanix.DAO.model.User;
import com.loyanix.DAO.repo.OrderDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Order order) {
        order.setStatus("CREATED");
        entityManager.persist(order);
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Order get(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void update(Long id, Order order) {
        order.setId(id);
        entityManager.merge(order);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> findAllOrders = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return findAllOrders.getResultList();
    }

    @Override
    public List<Order> findAllOrdersOfUser(User user) {
        TypedQuery<Order> findAllOrdersOfUser = entityManager.createQuery("SELECT FROM Order o WHERE o.user =:user", Order.class);
        findAllOrdersOfUser.setParameter("user", user);
        return findAllOrdersOfUser.getResultList();
    }
}
