package dev.nathan.user.service.converters;

import dev.nathan.user.dtos.UserDetailsDTO;
import dev.nathan.user.entity.User;
import dev.nathan.user.service.interfaces.UserConverter;
import org.springframework.stereotype.Component;

/**
 * Converter class for converting between {@link User} entity and {@link UserDetailsDTO}.
 * Implements the {@link UserConverter} interface to provide conversion functionality.
 *
 * @see User
 * @see UserDetailsDTO
 */
@Component
public class UserDetailsDTOConverter implements UserConverter<UserDetailsDTO> {

    /**
     * Converts a {@link UserDetailsDTO} to a {@link User} entity.
     *
     * @param dto the {@link UserDetailsDTO} to be converted.
     * @return the corresponding {@link User} entity.
     */
    @Override
    public User toEntity(UserDetailsDTO dto) {
        return User.builder().id(dto.id()).name(dto.name()).email(dto.email()).cpf(dto.cpf()).build();
    }

    /**
     * Converts a {@link User} entity to a {@link UserDetailsDTO}.
     *
     * @param user the {@link User} entity to be converted.
     * @return the corresponding {@link UserDetailsDTO}.
     */
    @Override
    public UserDetailsDTO toDto(User user) {
        return new UserDetailsDTO(user.getId(), user.getName(), user.getEmail(), user.getCpf());
    }
}
