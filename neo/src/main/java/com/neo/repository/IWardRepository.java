package com.neo.repository;

import com.neo.entities.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWardRepository extends JpaRepository<WardEntity,Integer> {
    @Query("SELECT w FROM wards w WHERE w.districtId = ?1")
    List<WardEntity> getByDistrictId(Integer id);
}
