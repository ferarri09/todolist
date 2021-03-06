package com.javabasics.service.user;

import com.javabasics.repository.entity.UserEntity;
import com.javabasics.repository.user.JpaUserDao;
import com.javabasics.repository.user.UserDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JpaUserDaoTest
{
    private UserDao userDao=new JpaUserDao();
    @Test
    public void idIsNotNullAfterSaving()
    {
        UserEntity userEntity=new UserEntity();
        userEntity.name="John2" + System.currentTimeMillis();
        userEntity.password="12345678";
        Long id=userDao.save(userEntity);
        assertTrue(id!=null && id!=0);
    }
    @Test
    public void userIsEqualUserAfterFinding() {
        UserEntity userEntity=new UserEntity();
        userEntity.name="John2" + System.currentTimeMillis();
        userEntity.password="12345678";
        Long id=userDao.save(userEntity);
        UserEntity returnedUserEntity = userDao.findById(id);
        assertEquals(userEntity, returnedUserEntity);
    }
    @Test
    public void userIsEqualUserAfterFindingByNameAndPassword()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.name="John2" + System.currentTimeMillis();
        userEntity.password="12345678";
        userDao.save(userEntity);
        UserEntity returnedUserEntity=userDao.findByNameAndPassword(userEntity.name,userEntity.password).get(1);
        assertEquals(userEntity, returnedUserEntity);
    }
}