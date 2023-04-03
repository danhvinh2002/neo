package com.neo.dto;

import com.neo.entities.UserEntity;
import lombok.*;

import java.sql.Date;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Integer province;
    private Integer district;
    private Integer wards;

    public UserDto(UserEntity userEntity){
        if(userEntity != null){
            setName(userEntity.getName());
            setEmail(userEntity.getEmail());
            setAddress(userEntity.getAddress());
            setAge(userEntity.getAge());
            setSex(userEntity.getSex());
            setBirthday(userEntity.getBirthday());
            setProvince(userEntity.getProvince().getProvinceId());
            setDistrict(userEntity.getDistrict().getDistrictId());
            setWards(userEntity.getWards().getWardId());
        }
}

    public UserDto() {
    }
}
