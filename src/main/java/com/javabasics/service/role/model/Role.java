package com.javabasics.service.role.model;

import java.util.Objects;

public class Role {
    public Long id;
    public String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role()
    {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
