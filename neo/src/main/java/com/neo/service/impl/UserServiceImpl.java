package com.neo.service.impl;

import com.neo.dto.UserDto;
import com.neo.entities.DistrictEntity;
import com.neo.entities.ProvinceEntity;
import com.neo.entities.UserEntity;
import com.neo.entities.WardEntity;
import com.neo.model.UserModel;
import com.neo.repository.IUserRepository;
import com.neo.service.IUserService;
import com.neo.utils.Validatation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    public UserDto getUserById(UserDto user,Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setBirthday(userEntity.getBirthday());
        user.setAddress(userEntity.getAddress());
        user.setProvince(userEntity.getProvince().getProvinceId());
        user.setDistrict(userEntity.getDistrict().getDistrictId());
        user.setWards(userEntity.getWards().getWardId());
        user.setAge(userEntity.getAge());
        user.setSex(userEntity.getSex());
        user.setEmail(userEntity.getEmail());
        return user;
    }

    @Override
    public UserDto addUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        convertToDto(user, userEntity);
        userEntity = userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        convertToDto(user, userEntity);
        userEntity = userRepository.save(userEntity);
        return user;
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

    public void convertToDto(UserDto userDto,UserEntity userEntity) {
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setAge(userDto.getAge());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setSex(userDto.getSex());
        userEntity.setBirthday(userDto.getBirthday());
        ProvinceEntity provinceEntity = new ProvinceEntity();
        DistrictEntity districtEntity = new DistrictEntity();
        WardEntity wardEntity = new WardEntity();
        provinceEntity.setProvinceId(userDto.getProvince());
        userEntity.setProvince(provinceEntity);
        districtEntity.setDistrictId(userDto.getDistrict());
        userEntity.setDistrict(districtEntity);
        wardEntity.setWardId(userDto.getWards());
        userEntity.setWards(wardEntity);
    }
}
