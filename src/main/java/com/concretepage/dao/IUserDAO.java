package com.concretepage.dao;

import com.concretepage.entity.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(String firstName, String lastName, String sex);
}
 