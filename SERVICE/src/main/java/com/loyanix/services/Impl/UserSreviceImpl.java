package com.loyanix.services.Impl;

import com.loyanix.services.DTO.UserDTO;
import com.loyanix.services.UserService;
import com.loyanix.services.convert.UserConvert;

import java.util.List;

public class UserSreviceImpl implements UserService {
    private final UserDTO userDTO;
    private final UserConvert userConvert;

    public UserSreviceImpl(UserDTO userDTO, UserConvert userConvert) {
        this.userDTO = userDTO;
        this.userConvert = userConvert;
    }

    public void delete(Long id) {

    }

    public void create(UserDTO user) {

    }

    public void update(Long id, UserDTO user) {

    }

    public UserDTO get(Long id) {
        return null;
    }

    public List<UserDTO> findAll() {
        return null;
    }
}
