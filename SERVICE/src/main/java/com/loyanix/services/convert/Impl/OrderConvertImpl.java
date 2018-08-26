package com.loyanix.services.convert.Impl;

import com.loyanix.DAO.model.Order;
import com.loyanix.services.DTO.OrderDTO;
import com.loyanix.services.convert.OrderConvetr;
import org.springframework.stereotype.Component;

@Component
public class OrderConvertImpl implements OrderConvetr {

    @Override
    public Order toEntity(OrderDTO dto) {
        return new Order(dto.getId(),
                dto.getUser(),
                dto.getProducts(),
                dto.getOrderPrice(),
                dto.getDateOfCreate(),
                dto.getStatus());
    }

    @Override
    public OrderDTO toDto(Order entity) {

        return new OrderDTO(entity.getId(),
                entity.getUser(),
                entity.getProducts(),
                entity.getOrderPrice(),
                entity.getDateOfCreate(),
                entity.getStatus());
    }
}
