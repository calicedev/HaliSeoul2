package com.godcoder.rest.repository;

import com.godcoder.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

 User findByUsername(String username);
}
