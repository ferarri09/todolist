package com.javabasics.controller;
import com.javabasics.repository.task.JpaTaskDao;
import com.javabasics.service.task.TaskService;
import com.javabasics.service.task.TaskServiceImpl;
import com.javabasics.service.task.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo-list/task")
public class TodoListController
{
    private TaskService taskService=new TaskServiceImpl(new JpaTaskDao());
    @PostMapping("save")
    public void save(@RequestBody Task task)
    {
        taskService.save(task);
    }
    @GetMapping("{userId}")
    public List<Task> save(@PathVariable Long userId)
    {
        return taskService.findByUserId(userId);
    }
}
