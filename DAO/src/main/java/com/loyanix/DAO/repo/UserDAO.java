package com.loyanix.DAO.repo;

import com.loyanix.DAO.model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);
    List<User> findAll();
    void delete(Long id);
    void update(Long id, User user);
    User get(Long id);
}
