package com.loyanix.services.Impl;

import com.loyanix.DAO.model.Order;
import com.loyanix.DAO.repo.OrderDAO;
import com.loyanix.DAO.repo.ProductDAO;
import com.loyanix.DAO.repo.UserDAO;
import com.loyanix.services.DTO.OrderDTO;
import com.loyanix.services.DTO.UserDTO;
import com.loyanix.services.OrderService;
import com.loyanix.services.convert.OrderConvetr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderConvetr orderConvetr;
    private final UserDAO userDAO;
    private final ProductDAO productDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, OrderConvetr orderConvetr, UserDAO userDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.orderConvetr = orderConvetr;
        this.userDAO = userDAO;
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public void create(OrderDTO orderDTO) {
        orderDAO.create(orderConvetr.toEntity(orderDTO));
    }

    @Override
    @Transactional
    public void updete(Long id, OrderDTO orderDTO) {

    }

    @Override
    @Transactional
    public OrderDTO get(Long id) {
        return null;
    }

    @Override
    @Transactional
    public List<OrderDTO> findAll() {

        List<Order> orders = orderDAO.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order: orders){
            orderDTOS.add(orderConvetr.toDto(order));
        }
        return orderDTOS;
    }

    @Override
    @Transactional
    public List<OrderDTO> findAllOrdersOfUser(UserDTO user) {
        return null;
    }
}
