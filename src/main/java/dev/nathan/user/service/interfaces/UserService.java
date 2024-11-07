package dev.nathan.user.service.interfaces;

import dev.nathan.user.dtos.UpdateUserFormDTO;
import dev.nathan.user.dtos.UserDTO;
import dev.nathan.user.dtos.UserDetailsDTO;
import dev.nathan.user.dtos.UserFormDTO;

import java.util.List;

/**
 * Interface for user management operations.
 * <p>
 * Provides methods to create, update, retrieve, and delete users.
 */
public interface UserService {

    /**
     * Creates a new user from the given user form data.
     *
     * @param userFormDTO the user data for creation
     * @return the created user as a {@link UserDTO}
     */
    UserDTO createUser(UserFormDTO userFormDTO);

    /**
     * Retrieves all users.
     *
     * @return a list of {@link UserDetailsDTO}s for all users
     */
    List<UserDetailsDTO> getUsers();

    /**
     * Finds a user by ID and returns the details as a {@link UserDetailsDTO}.
     *
     * @param id the user ID
     * @return the user details as a {@link UserDetailsDTO}
     * @throws dev.nathan.user.service.exceptions.UserNotFoundException if the user is not found
     */
    UserDetailsDTO findUserById(Long id);

    /**
     * Updates an existing user based on provided data.
     *
     * @param id                the ID of the user to update
     * @param updateUserFormDTO the data to update the user with
     * @return the updated user as a {@link UserDTO}
     * @throws dev.nathan.user.service.exceptions.UserNotFoundException if the user is not found
     */
    UserDTO updateUser(Long id, UpdateUserFormDTO updateUserFormDTO);

    /**
     * Deletes a user by ID.
     *
     * @param id the user ID to delete
     * @throws dev.nathan.user.service.exceptions.UserNotFoundException if the user is not found
     */
    void deleteUser(Long id);
}
