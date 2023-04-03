package com.neo.service.impl;

import com.neo.entities.DistrictEntity;
import com.neo.repository.IDistrictRepository;
import com.neo.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public List<DistrictEntity> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<DistrictEntity> getByProvinceId(Integer id) {
        return districtRepository.getByProvinceId(id);
    }
}
