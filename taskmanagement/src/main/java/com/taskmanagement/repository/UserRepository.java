package com.taskmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.taskmanagement.entity.User;



@Repository
// @EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    Optional<User> findOneByUserNameAndPassword(String userName, String password);
} 
