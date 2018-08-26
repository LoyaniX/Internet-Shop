package com.loyanix.services.convert;

import com.loyanix.DAO.model.Order;
import com.loyanix.services.DTO.OrderDTO;

public interface OrderConvetr {
    Order toEntity(OrderDTO dto);
    OrderDTO toDto(Order entity);
}
