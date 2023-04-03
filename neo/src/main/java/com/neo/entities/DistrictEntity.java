package com.neo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "district")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DistrictEntity {
    @Id
    @Column(name = "district_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer districtId;
    @Column(name = "province_id")
    private Integer provinceId;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "ward_id")
    @OneToMany
    private List<WardEntity> wards;

}
