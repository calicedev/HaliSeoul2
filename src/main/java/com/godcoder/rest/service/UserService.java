package com.godcoder.rest.service;

import com.godcoder.rest.model.Role;
import com.godcoder.rest.model.User;
import com.godcoder.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        Role role= new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    public HashMap<String, Object> usernameOverlap(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", userRepository.existsByUsername(username));
        return map;
    }
}