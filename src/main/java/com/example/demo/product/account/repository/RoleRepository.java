package com.example.demo.product.account.repository;

import com.example.demo.product.account.entity.Role;
import com.example.demo.product.account.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
