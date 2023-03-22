package com.neo.service.impl;

import com.neo.entities.UserEntity;
import com.neo.repository.IUserRepository;
import com.neo.service.IUserService;
import com.neo.utils.Validatation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        userEntity.checkSex();
        Validatation validatation = new Validatation();
        validatation.checkNameNull(userEntity.getName());
        validatation.checkName(userEntity.getName());
        validatation.checkAge(userEntity.getAge());
        validatation.checkEmail(userEntity.getEmail());
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        Validatation validatation = new Validatation();
        validatation.checkName(userEntity.getName());
        validatation.checkAge(userEntity.getAge());
        validatation.checkEmail(userEntity.getEmail());
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<UserEntity> sortByName() {
        return userRepository.sortByName();
    }
}
