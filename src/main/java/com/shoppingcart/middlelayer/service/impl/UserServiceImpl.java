package com.shoppingcart.middlelayer.service.impl;

import com.shoppingcart.middlelayer.dto.User;
import com.shoppingcart.middlelayer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> userMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AtomicInteger id = new AtomicInteger(1);

    @Override
    public List<User> getUsers() {
        userMap.put(1, new User());
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUser(Integer userId) {
        return userMap.get(userId);
    }

    @Override
    public boolean createUser(User user) {
        try {
            user.setId(id.getAndIncrement());
            userMap.put(user.getId(), user);
            return true;
        } catch (Exception ex) {
            logger.debug("Exception occurred");
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            userMap.replace(user.getId(), user);
            return true;
        } catch (Exception ex) {
            logger.debug("Exception occurred");
        }
        return false;
    }

    @Override
    public void deleteUser(Integer userId) {
        userMap.remove(userId);
    }
}