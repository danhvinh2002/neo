package com.neo.service;

import com.neo.entities.WardEntity;

import java.util.List;

public interface IWardService {
    List<WardEntity> findAll();
    List<WardEntity> getByDistrictId(Integer id);
}
