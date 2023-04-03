package com.neo.service;

import com.neo.entities.DistrictEntity;

import java.util.List;

public interface IDistrictService {
    List<DistrictEntity> findAll();

    List<DistrictEntity> getByProvinceId(Integer id);
}
