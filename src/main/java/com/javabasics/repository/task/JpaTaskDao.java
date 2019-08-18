package com.javabasics.repository.task;
import com.javabasics.repository.*;
import com.javabasics.repository.entity.TaskEntity;
import java.util.List;

public class JpaTaskDao extends GenericDao<TaskEntity> implements TaskDao{
    @Override
    public List<TaskEntity> findByUserId(Long userId) {
        return null;
    }
}
