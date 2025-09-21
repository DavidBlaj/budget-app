package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.User;
import com.bd.budget.repositories.UserRepository;
import com.bd.budget.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The user with given id does not exist: " + userId));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, User updatedUser) {
        User user = findById(userId);

        user.setEmail(updatedUser.getEmail());
        user.setPasswordHash(updatedUser.getPasswordHash());
        user.setUsername(updatedUser.getUsername());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        User user = findById(userId);

        userRepository.delete(user);
    }
}