package com.example.gymapp.service.impl;

import com.example.gymapp.dao.entity.User;
import com.example.gymapp.dao.repository.UserRepository;
import com.example.gymapp.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}
