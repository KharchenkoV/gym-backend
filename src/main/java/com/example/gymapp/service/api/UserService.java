package com.example.gymapp.service.api;

import com.example.gymapp.dao.entity.User;

public interface UserService {
    User getUserByEmail(String email);
}
