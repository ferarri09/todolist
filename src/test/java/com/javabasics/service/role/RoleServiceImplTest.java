package com.javabasics.service.role;
import com.javabasics.repository.role.JdbcRoleDao;
import com.javabasics.repository.role.RoleDao;
import com.javabasics.service.role.model.Role;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    @Test
    public void roleIsNotNullAfterFinding()
    {
        Role role=new Role();
        role.name="user"+System.currentTimeMillis();
        Long id=roleService.save(role);
        Role returnedRole=roleService.findById(id);
        assertEquals(role,returnedRole);
    }
    @Test
    public void rolesIsNotNullAfterFindingAll()
    {
        List<Role> roles;
        roles=roleService.findAll();
        assertTrue(!roles.isEmpty());
    }
}