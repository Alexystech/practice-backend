package com.practice.slasher.service;

import com.practice.slasher.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void deleteUserByClave(int clave);
    User updateUser(User user);
    User getUserByClave(int clave);
    List<User> getAllUsers();
}
