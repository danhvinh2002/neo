package com.neo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity(name = "wards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WardEntity {
    @Id
    @Column(name = "wards_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wardId;
    @Column(name = "district_id")
    private Integer districtId;
    @Column(name = "name")
    private String name;
}
