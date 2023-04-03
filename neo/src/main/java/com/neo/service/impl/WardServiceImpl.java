package com.neo.service.impl;

import com.neo.entities.WardEntity;
import com.neo.repository.IWardRepository;
import com.neo.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements IWardService {

    @Autowired
    private IWardRepository wardRepository;

    @Override
    public List<WardEntity> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public List<WardEntity> getByDistrictId(Integer id) {
        return wardRepository.getByDistrictId(id);
    }
}
