package com.neo.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "tbl_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "email", length = 50,nullable = false)
    private String email;
    @Column(name = "age", length = 2,nullable = false)
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "phone", length = 10)
    private Integer sex;
    @Column(name = "birthday")
    private Date birthday;
    @JoinColumn(name="province")
    @OneToOne
    private ProvinceEntity province;
    @JoinColumn(name="district")
    @OneToOne
    private DistrictEntity district;
    @JoinColumn(name="wards")
    @OneToOne
    private WardEntity wards;

    public String checkSex() {
        if (sex == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
}
