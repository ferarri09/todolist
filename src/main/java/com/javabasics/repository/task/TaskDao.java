package com.javabasics.repository.task;
import com.javabasics.repository.entity.TaskEntity;
import java.util.List;
public interface TaskDao {
    Long save(TaskEntity task);
    TaskEntity findById(Long id);
    List<TaskEntity> findByUserId(Long userId);
}
