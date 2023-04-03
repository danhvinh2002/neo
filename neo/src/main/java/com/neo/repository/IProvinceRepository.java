package com.neo.repository;

import com.neo.entities.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {
    @Query("SELECT p FROM province p WHERE p.provinceId = ?1")
    ProvinceEntity getById(Integer id);
}
