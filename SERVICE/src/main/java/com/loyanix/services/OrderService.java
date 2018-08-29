package com.loyanix.services;

import com.loyanix.services.DTO.OrderDTO;
import com.loyanix.services.DTO.UserDTO;

import java.util.List;

public interface OrderService {

    void create(OrderDTO orderDTO);
    void delete(Long id);
    void update(Long id, OrderDTO orderDTO);
    OrderDTO get(Long id);
    List<OrderDTO> findAll();
    List<OrderDTO> findAllOrdersOfUser(UserDTO user);
}
