package com.neo.repository;

import com.neo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT u FROM tbl_user u WHERE u.name LIKE %:name%")
    List<UserEntity> findByName(@Param("name") String name);

    @Query("Select u From tbl_user u order by u.name")
    List<UserEntity> sortByName();
}
