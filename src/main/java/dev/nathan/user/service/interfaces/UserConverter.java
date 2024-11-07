package dev.nathan.user.service.interfaces;

import dev.nathan.user.entity.User;

/**
 * Converts between a {@link User} entity and its corresponding Data Transfer Object (DTO).
 *
 * @param <T> the type of DTO being converted
 */
public interface UserConverter<T> {

    /**
     * Converts a DTO to a {@link User} entity.
     *
     * @param dto the DTO to convert
     * @return the corresponding {@link User} entity
     */
    User toEntity(T dto);

    /**
     * Converts a {@link User} entity to a DTO.
     *
     * @param user the {@link User} entity to convert
     * @return the corresponding DTO
     */
    T toDto(User user);
}
