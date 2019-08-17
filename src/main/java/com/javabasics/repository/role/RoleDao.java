package com.javabasics.repository.role;

import com.javabasics.repository.entity.RoleEntity;
import com.javabasics.service.role.model.Role;

import java.util.List;

public interface RoleDao {
    Long save(RoleEntity roleEntity);
    RoleEntity findById(Long id);

    List<Role> findAll();
}
