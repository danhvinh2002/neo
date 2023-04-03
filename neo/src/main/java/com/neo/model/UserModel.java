package com.neo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
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
}
