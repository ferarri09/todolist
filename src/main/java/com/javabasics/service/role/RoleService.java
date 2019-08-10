package com.javabasics.service.role;

import com.javabasics.service.role.model.Role;

import java.util.List;

public interface RoleService {
    Long save(Role role);
    Role findById(Long id);
    List findAll();
}
