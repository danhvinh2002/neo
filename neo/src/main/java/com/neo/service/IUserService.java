package com.neo.service;

import com.neo.dto.UserDto;
import com.neo.entities.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUsers();
    UserDto getUserById(UserDto user,Integer id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Integer id);
    List<UserEntity> findByName(String name);
    List<UserEntity> sortByName();
}
