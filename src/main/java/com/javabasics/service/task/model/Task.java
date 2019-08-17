package com.javabasics.service.task.model;
public class Task {
    public Long id;
    public String name;
    public Long userId;

    public Task() {
    }
    public Task(Long id, String name, Long userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
