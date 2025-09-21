package com.bd.budget.services;

import com.bd.budget.models.User;

import java.util.List;

public interface UserService {

    User findById(Long userId);

    List<User> findAll();

    User addUser(User user);

    User update(Long userId, User updatedUser);

    void delete(Long userId);
}