package com.loyanix.DAO.repo;

import com.loyanix.DAO.model.Order;
import com.loyanix.DAO.model.User;

import java.util.List;

public interface OrderDAO {

    void create(Order order);
    void delete(Long id);
    void update(Long id, Order order);
    Order get(Long id);
    List<Order> findAll();
    List<Order> findAllOrdersOfUser(User user);

}
