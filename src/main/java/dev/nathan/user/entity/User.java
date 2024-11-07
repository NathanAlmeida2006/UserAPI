package dev.nathan.user.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * User entity representing a user in the system.
 * This class is mapped to a table in the database and holds
 * all relevant user information.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User's name.
     */
    @Column(nullable = false)
    private String name;

    /**
     * User's email.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * User's CPF (Brazilian individual taxpayer registry identificati on).
     */
    @Column(nullable = false, unique = true)
    private String cpf;
}
