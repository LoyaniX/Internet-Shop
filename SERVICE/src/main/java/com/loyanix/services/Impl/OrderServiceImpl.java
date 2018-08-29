package com.loyanix.services.Impl;

import com.loyanix.DAO.model.Order;
import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.repo.OrderDAO;
import com.loyanix.DAO.repo.ProductDAO;
import com.loyanix.DAO.repo.UserDAO;
import com.loyanix.services.DTO.OrderDTO;
import com.loyanix.services.DTO.UserDTO;
import com.loyanix.services.OrderService;
import com.loyanix.services.convert.Impl.OrderConvertImpl;
import com.loyanix.services.convert.Impl.UserConvertImpl;
import com.loyanix.services.convert.OrderConvetr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderConvetr orderConvetr;
    private final UserDAO userDAO;
    private final ProductDAO productDAO;
    private Set<Product> productSet;
    private Integer price;
    private UserConvertImpl userConvert;
    private OrderConvertImpl orderConvert;

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
        orderDAO.delete(id);
    }

    @Override
    @Transactional
    public void create(OrderDTO orderDTO) {
        productSet = orderDTO.getProducts();
        price = 0;
        for(Product product: productSet){
            price += product.getPrice();
        }
        orderDTO.setOrderPrice(price);
        orderDAO.create(orderConvetr.toEntity(orderDTO));
    }

    @Override
    @Transactional
    public void update(Long id, OrderDTO orderDTO) {
        productSet = orderDTO.getProducts();
        price = 0;
        for(Product product: productSet){
            price += product.getPrice();
        }
        orderDTO.setOrderPrice(price);
        orderDAO.update(id, orderConvetr.toEntity(orderDTO));
    }

    @Override
    @Transactional
    public OrderDTO get(Long id) {
        return orderConvetr.toDto(orderDAO.get(id));
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

        List<Order> userOrders = orderDAO.findAllOrdersOfUser(userConvert.toEntity(user));
        List<OrderDTO> userOrderDTOS = new ArrayList<>();
        userOrders.forEach(userOrder -> userOrderDTOS.add(orderConvert.toDto(userOrder)));
        return userOrderDTOS;
    }
}
