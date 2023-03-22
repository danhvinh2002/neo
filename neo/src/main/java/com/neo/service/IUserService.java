package com.neo.service;

import com.neo.entities.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Integer id);
    UserEntity addUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(Integer id);
    List<UserEntity> findByName(String name);
    List<UserEntity> sortByName();
}
