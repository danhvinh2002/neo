package com.neo.repository;

import com.neo.entities.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDistrictRepository extends JpaRepository<DistrictEntity, Integer> {

    @Query("SELECT d FROM district d WHERE d.provinceId = ?1")
    List<DistrictEntity> getByProvinceId(Integer id);
}
