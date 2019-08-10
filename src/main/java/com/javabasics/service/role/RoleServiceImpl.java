package com.javabasics.service.role;

import com.javabasics.repository.entity.RoleEntity;
import com.javabasics.repository.role.RoleDao;
import com.javabasics.service.role.model.Role;

public class RoleServiceImpl implements RoleService{
    RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao)
    {
        this.roleDao=roleDao;
    }
    @Override
    public Long save(Role role) {
        return roleDao.save(roleToRoleEntity(role));
    }



    @Override
    public Role findById(Long id) {
        return roleEntityToRole(roleDao.findById(id));
    }
    private RoleEntity roleToRoleEntity(Role role) {
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.id=role.id;
        roleEntity.name=role.name;
        return roleEntity;
    }
    private Role roleEntityToRole(RoleEntity roleEntity) {
        Role role=new Role();
        role.id=roleEntity.id;
        role.name=roleEntity.name;
        return role;
    }
}
