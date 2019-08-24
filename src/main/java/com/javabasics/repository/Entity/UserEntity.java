package com.javabasics.repository.entity;

import com.javabasics.repository.Id;
import com.javabasics.repository.Table;

import java.util.Objects;

@Table("user")
public class UserEntity{
    @Id
    public Long id;
    public String name;
    public String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
