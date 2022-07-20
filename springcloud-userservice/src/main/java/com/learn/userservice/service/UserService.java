package com.learn.userservice.service;

import com.learn.userservice.domain.User;

import java.util.List;

/**
 * @Author:liwy
 * @date: 22.7.18
 * @Version:1.0
 */
public interface UserService {

    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
