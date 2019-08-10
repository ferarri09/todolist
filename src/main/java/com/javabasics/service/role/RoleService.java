package com.javabasics.service.role;

import com.javabasics.service.role.model.Role;

public interface RoleService {
    Long save(Role role);
    Role findById(Long id);
}
