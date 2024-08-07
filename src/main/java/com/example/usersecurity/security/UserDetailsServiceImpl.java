package com.example.usersecurity.security;

import com.example.usersecurity.entity.UserEntity;
import com.example.usersecurity.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity= userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email " + username + " not found"));
        return UserDetailsImpl.build(userEntity);
    }
}