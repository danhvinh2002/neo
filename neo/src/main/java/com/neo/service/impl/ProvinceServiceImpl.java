package com.neo.service.impl;

import com.neo.entities.ProvinceEntity;
import com.neo.repository.IProvinceRepository;
import com.neo.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public List<ProvinceEntity> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public ProvinceEntity getById(Integer id) {
        return provinceRepository.getById(id);
    }
}
