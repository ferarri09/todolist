package com.javabasics.repository.role;

import com.javabasics.repository.entity.RoleEntity;

import java.util.List;

public interface RoleDao {
    Long save(RoleEntity roleEntity);
    RoleEntity findById(Long id);

    List findAll();
}
