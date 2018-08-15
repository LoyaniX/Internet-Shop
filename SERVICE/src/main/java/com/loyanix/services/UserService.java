package com.loyanix.services;

import com.loyanix.services.DTO.UserDTO;

import java.util.List;

public interface UserService {
    void create(UserDTO user);
    List<UserDTO> findAll();
    void delete(Long id);
    void update(Long id, UserDTO user);
    UserDTO get(Long id);
}
