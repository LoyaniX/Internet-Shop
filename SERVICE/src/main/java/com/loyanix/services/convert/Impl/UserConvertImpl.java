package com.loyanix.services.convert.Impl;

import com.loyanix.DAO.model.User;
import com.loyanix.services.DTO.UserDTO;
import com.loyanix.services.convert.UserConvert;
import org.springframework.stereotype.Component;

@Component
public class UserConvertImpl implements UserConvert {
    @Override
    public User toEntity(UserDTO dto) {
        return new User(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge(),
                dto.getId());
    }
    @Override
    public UserDTO toDto(User entity){
        return new UserDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge());
    }
}
