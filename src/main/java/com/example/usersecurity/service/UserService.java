package com.example.usersecurity.service;

import com.example.usersecurity.entity.UserEntity;
import com.example.usersecurity.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepo userRepo;

    private BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    };

    public void save(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }
}
