package com.javabasics.service.user;
import com.javabasics.service.user.model.User;
public interface UserService {
    Long save(User user);
    User findById(Long id);
    User findByNameAndPassword(String name, String password);
}