package com.godcoder.rest.repository;

import com.godcoder.rest.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

 @EntityGraph(attributePaths = {"members"})
 List<User> findAll();

 User findByUsername(String username);

}
