package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepository extends JpaRepository<User,Long> {
    @Query(value = "select u from User u where u.email=?1")
    public User getUserByEmail(String email);
}
