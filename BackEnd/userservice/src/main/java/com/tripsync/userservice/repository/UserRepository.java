package com.tripsync.userservice.repository;

import com.tripsync.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
    User findByUserEmail(String email);
}
