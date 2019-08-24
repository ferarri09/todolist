package com.javabasics.repository.entity;

import com.javabasics.repository.Column;
import com.javabasics.repository.Id;
import com.javabasics.repository.Table;

import java.util.Objects;

@Table("task")
public class TaskEntity {
    @Id
    public Long id;
    public String name;
    @Column("user_id")
    public Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userId);
    }
}
