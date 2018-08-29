package com.loyanix.services.Impl;

import com.loyanix.DAO.model.User;
import com.loyanix.DAO.repo.UserDAO;
import com.loyanix.services.DTO.UserDTO;
import com.loyanix.services.UserService;
import com.loyanix.services.convert.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSreviceImpl implements UserService {
    private final UserDAO userDao;
    private final UserConvert userConvert;

    @Autowired
    public UserSreviceImpl(UserDAO userDao, UserConvert userConvert) {
        this.userDao = userDao;
        this.userConvert = userConvert;
    }

    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
    @Transactional
    public void create(UserDTO user) {
        userDao.create(userConvert.toEntity(user));
    }
    @Transactional
    public void update(Long id, UserDTO user) {
        userDao.update(id, userConvert.toEntity(user));
    }
    @Transactional(readOnly = true)
    public UserDTO get(Long id) {
        return userConvert.toDto(userDao.get(id));
    }
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userDao.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            userDTOS.add(userConvert.toDto(user));
        }
        return userDTOS;
    }
}
