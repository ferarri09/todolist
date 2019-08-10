package com.javabasics.repository.role;

import com.javabasics.repository.entity.RoleEntity;

public interface RoleDao {
    Long save(RoleEntity roleEntity);
    RoleEntity findById(Long id);
}
