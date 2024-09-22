package dev.nathan.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO for updating an existing User.
 */
@Getter
@AllArgsConstructor
public class UpdateUserFormDTO {

    private String name;
    private String email;
    private String cpf;
}
