package com.neo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "province")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "province_id")
    private Integer provinceId;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "province_id")
    @OneToMany
    private List<DistrictEntity> districtId;
}
