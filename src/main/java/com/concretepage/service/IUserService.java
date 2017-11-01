package com.concretepage.service;

import com.concretepage.entity.User;

import java.util.List;

public interface IUserService {
     List<User> getAllUsers();
     User getUserById(int userId);
     boolean addUser(User user);
     void updateUser(User user);
     void deleteUser(int userId);
}
