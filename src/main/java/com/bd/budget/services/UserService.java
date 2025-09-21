package com.bd.budget.services;

import com.bd.budget.models.User;

import java.util.List;

public interface UserService {

    User findUserById(Long userId);

    List<User> findAllUsers();

    User addUser(User user);

    User updateUser(Long userId, User updatedUser);

    void deleteUser(Long userId);
}