package dev.nathan.user.service.converters;

import dev.nathan.user.dtos.UserFormDTO;
import dev.nathan.user.entity.User;
import dev.nathan.user.service.interfaces.UserConverter;
import org.springframework.stereotype.Component;

/**
 * Converter class for converting between {@link UserFormDTO} and {@link User} entity.
 * Implements the {@link UserConverter} interface to provide conversion functionality.
 *
 * @see User
 * @see UserFormDTO
 */
@Component
public class UserFormDTOConverter implements UserConverter<UserFormDTO> {

    /**
     * Converts a {@link UserFormDTO} to a {@link User} entity.
     *
     * @param dto the {@link UserFormDTO} to be converted.
     * @return the corresponding {@link User} entity.
     */
    @Override
    public User toEntity(UserFormDTO dto) {
        return User.builder().name(dto.name()).email(dto.email()).cpf(dto.cpf()).build();
    }

    /**
     * Throws an {@link UnsupportedOperationException} because conversion from {@link User} to {@link UserFormDTO} is not supported.
     *
     * @param user the {@link User} entity.
     * @throws UnsupportedOperationException if this method is called.
     */
    @Override
    public UserFormDTO toDto(User user) {
        throw new UnsupportedOperationException("Conversion from User to UserFormDTO is not supported");
    }
}
