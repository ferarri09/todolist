package com.javabasics.controller;
import org.springframework.web.bind.annotation.*;
import com.javabasics.service.Model.*;

@RestController
@RequestMapping("todo-list")
public class TodoListController
{
    @GetMapping("hi")
    public String helloWorld()
    {
        return "Hi!!!";
    }
    @PostMapping("save-task")
    public void saveTask(@RequestBody TaskDTO task)
    {
        System.out.println(task.name);
    }
}
