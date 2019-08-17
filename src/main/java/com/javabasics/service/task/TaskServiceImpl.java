package com.javabasics.service.task;
import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.service.task.model.Task;
import java.util.List;
import java.util.stream.Collectors;
public class TaskServiceImpl implements TaskService
{
    private TaskDao taskDao;
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Long save(Task task) {
        return taskDao.save(taskToTaskEntity(task));
    }
    @Override
    public Task findById(Long id) {

        return convertToTask(taskDao.findById(id));
    }
    @Override
    public List<Task> findByUserId(Long userId) {
        return taskDao.findByUserId(userId).stream()
                .map(this::convertToTask)
                .collect(Collectors.toList());
    }
    private Task convertToTask(TaskEntity taskEntity)
    {
        Task task=new Task();
        task.id=taskEntity.id;
        task.name=taskEntity.name;
        task.userId=taskEntity.userId;
        return task;
    }
    private TaskEntity taskToTaskEntity(Task task)
    {
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.id=task.id;
        taskEntity.name=task.name;
        taskEntity.userId=task.userId;
        return taskEntity;
    }
}
