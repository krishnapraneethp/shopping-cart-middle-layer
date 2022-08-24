package com.shoppingcart.middlelayer.service;

import com.shoppingcart.middlelayer.dto.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer userId);

    boolean createUser(User user);

    boolean updateUser(User user);

    void deleteUser(Integer userId);
}