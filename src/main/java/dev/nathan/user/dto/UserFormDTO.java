package dev.nathan.user.dto;

import dev.nathan.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO for creating a new User.
 */
@Getter
@AllArgsConstructor
public class UserFormDTO {

    private String name;
    private String email;
    private String cpf;

    public User toEntity() {
        return User.builder().name(name).email(email).cpf(cpf).build();
    }
}
