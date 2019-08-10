package com.javabasics.service.role;

import com.javabasics.repository.role.JdbcRoleDao;
import com.javabasics.repository.role.RoleDao;
import com.javabasics.service.role.model.Role;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class RoleServiceImplTest {
    RoleDao roleDao=new JdbcRoleDao();
    RoleService roleService=new RoleServiceImpl(roleDao);
    @Test
    public void checkReturnedIdAfterSaving()
    {
        Role role=new Role();
        role.name="user"+System.currentTimeMillis();
        Long id=roleService.save(role);
        assertTrue(id!=null && id!=0);
    }
}
