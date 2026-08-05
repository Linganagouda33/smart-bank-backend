package com.smartbank.smart_bank_backend.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.smartbank.smart_bank_backend.entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String roleName);

}
