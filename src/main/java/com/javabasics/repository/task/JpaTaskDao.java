package com.javabasics.repository.task;
import com.javabasics.repository.*;
import com.javabasics.repository.entity.TaskEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaTaskDao extends GenericDao<TaskEntity> implements TaskDao{
    @Override
    public List<TaskEntity> findByUserId(Long userId) {
        Map<String,Object> params=new HashMap<>();
        params.put("user_id",userId);
        return findByParameters(params);
    }
}
