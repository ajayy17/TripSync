package com.tripsync.userservice.repository;

import com.tripsync.userservice.model.AppRole;
import com.tripsync.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}