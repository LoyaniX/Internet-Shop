package com.loyanix.DAO.repo;

import com.loyanix.DAO.model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);
    User get(Long id);
    void update(Long id, User user);
    void delete(Long id);
    List<User> findAll();
}
