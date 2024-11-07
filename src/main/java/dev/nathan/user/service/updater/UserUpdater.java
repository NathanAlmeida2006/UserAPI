package dev.nathan.user.service.updater;

import dev.nathan.user.dtos.UpdateUserFormDTO;
import dev.nathan.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * Component responsible for updating the fields of a {@link User} entity
 * based on the data provided in an {@link UpdateUserFormDTO}.
 */
@Component
public class UserUpdater {

    /**
     * Updates the fields of the given {@link User} entity based on the provided {@link UpdateUserFormDTO}.
     * The method updates only the fields that are not null and different from the existing user data.
     *
     * @param user              the {@link User} entity to be updated
     * @param updateUserFormDTO the data used to update the user
     */
    public void updateUser(User user, UpdateUserFormDTO updateUserFormDTO) {
        if (updateUserFormDTO.name() != null && !updateUserFormDTO.name().equals(user.getName())) {
            user.setName(updateUserFormDTO.name());
        }
        if (updateUserFormDTO.email() != null && !updateUserFormDTO.email().equals(user.getEmail())) {
            user.setEmail(updateUserFormDTO.email());
        }
        if (updateUserFormDTO.cpf() != null && !updateUserFormDTO.cpf().equals(user.getCpf())) {
            user.setCpf(updateUserFormDTO.cpf());
        }
    }
}
