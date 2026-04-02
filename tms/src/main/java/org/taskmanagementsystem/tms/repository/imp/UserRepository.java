package org.taskmanagementsystem.tms.repository.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanagementsystem.tms.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
