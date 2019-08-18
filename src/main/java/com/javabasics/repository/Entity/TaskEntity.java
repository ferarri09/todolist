package com.javabasics.repository.entity;

import com.javabasics.repository.Column;
import com.javabasics.repository.Id;

public class TaskEntity {
    @Id
    public Long id;
    public String name;
    @Column("user_id")
    public Long userId;
}
