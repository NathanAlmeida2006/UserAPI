package dev.nathan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.nathan.user.entity.User;

/**
 * Repository for managing User entities.
 * Handles all database operations for User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
