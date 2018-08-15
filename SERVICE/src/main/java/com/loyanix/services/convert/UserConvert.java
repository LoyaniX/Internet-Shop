package com.loyanix.services.convert;

import com.loyanix.DAO.model.User;
import com.loyanix.services.DTO.UserDTO;

public interface UserConvert {
    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
}
