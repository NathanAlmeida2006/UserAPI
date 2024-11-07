package dev.nathan.user.service.converters;

import dev.nathan.user.dtos.UserDTO;
import dev.nathan.user.entity.User;
import dev.nathan.user.service.interfaces.UserConverter;
import org.springframework.stereotype.Component;

/**
 * Converter class for converting between {@link User} entity and {@link UserDTO}.
 * Implements the {@link UserConverter} interface to provide conversion functionality.
 *
 * @see User
 * @see UserDTO
 */
@Component
public class UserDTOConverter implements UserConverter<UserDTO> {

    /**
     * Converts a {@link UserDTO} to a {@link User} entity.
     *
     * @param dto the {@link UserDTO} to be converted.
     * @return the corresponding {@link User} entity.
     */
    @Override
    public User toEntity(UserDTO dto) {
        return User.builder().id(dto.id()).name(dto.name()).email(dto.email()).cpf(dto.cpf()).build();
    }

    /**
     * Converts a {@link User} entity to a {@link UserDTO}.
     *
     * @param user the {@link User} entity to be converted.
     * @return the corresponding {@link UserDTO}.
     */
    @Override
    public UserDTO toDto(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getCpf());
    }
}
