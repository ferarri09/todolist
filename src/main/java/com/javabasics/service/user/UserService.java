package com.javabasics.service.user;

import com.javabasics.service.Model.User;

public interface UserService {
    Long save(User user);
    User findById(Long id);
}
