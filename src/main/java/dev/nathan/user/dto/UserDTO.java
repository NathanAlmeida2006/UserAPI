package dev.nathan.user.dto;

import dev.nathan.user.entity.User;
import lombok.Getter;

/**
 * DTO for transferring user data.
 */
@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
    }
}
