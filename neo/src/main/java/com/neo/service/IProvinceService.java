package com.neo.service;

import com.neo.entities.ProvinceEntity;

import java.util.List;

public interface IProvinceService {
    List<ProvinceEntity> findAll();

    ProvinceEntity getById(Integer id);
}
