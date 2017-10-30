package com.sermon.dao;

import com.sermon.model.UserRemote;

import java.util.List;

public interface UserDao {
    List<UserRemote> getUsers();
    UserRemote getUser(String username);
    void createUser(UserRemote user);
    void updateUser(UserRemote user);
    void deleteUser(UserRemote user);
}
