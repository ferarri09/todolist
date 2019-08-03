package com.javabasics.service.Model;

import java.util.Objects;

public class Task {
    public String name;
    public User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, user);
    }
}
