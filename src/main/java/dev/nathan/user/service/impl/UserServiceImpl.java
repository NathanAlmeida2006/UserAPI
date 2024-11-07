package dev.nathan.user.service.impl;

import dev.nathan.user.dtos.UpdateUserFormDTO;
import dev.nathan.user.dtos.UserDTO;
import dev.nathan.user.dtos.UserDetailsDTO;
import dev.nathan.user.dtos.UserFormDTO;
import dev.nathan.user.entity.User;
import dev.nathan.user.repository.UserRepository;
import dev.nathan.user.service.converters.UserDTOConverter;
import dev.nathan.user.service.converters.UserDetailsDTOConverter;
import dev.nathan.user.service.converters.UserFormDTOConverter;
import dev.nathan.user.service.exceptions.UserNotFoundException;
import dev.nathan.user.service.interfaces.UserService;
import dev.nathan.user.service.updater.UserUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link UserService} interface.
 * Provides methods to handle user management such as creating, updating, retrieving, and deleting users.
 * The service uses DTOs (Data Transfer Objects) for communication with other layers.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDTOConverter userDtoConverter;
    private final UserDetailsDTOConverter userDetailsDtoConverter;
    private final UserFormDTOConverter userFormDtoConverter;
    private final UserUpdater userUpdater;

    /**
     * Creates a new user from the provided {@link UserFormDTO} and saves it to the database.
     *
     * @param userFormDTO the data transfer object containing the user's information
     * @return a {@link UserDTO} representing the created user
     */
    @Override
    public UserDTO createUser(UserFormDTO userFormDTO) {
        User user = userFormDtoConverter.toEntity(userFormDTO);
        user = userRepository.save(user);
        return userDtoConverter.toDto(user);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of {@link UserDetailsDTO} representing all users
     */
    @Override
    public List<UserDetailsDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userDetailsDtoConverter::toDto).collect(Collectors.toList());
    }

    /**
     * Retrieves a user by its unique identifier.
     *
     * @param id the unique identifier of the user
     * @return a {@link UserDetailsDTO} representing the user
     * @throws UserNotFoundException if no user is found with the provided id
     */
    @Override
    public UserDetailsDTO getUserById(Long id) {
        User user = findUserById(id);
        return userDetailsDtoConverter.toDto(user);
    }

    /**
     * Updates the user information based on the provided {@link UpdateUserFormDTO}.
     *
     * @param id                the unique identifier of the user to be updated
     * @param updateUserFormDTO the data transfer object containing the updated information
     * @return a {@link UserDTO} representing the updated user
     * @throws UserNotFoundException if no user is found with the provided id
     */
    @Override
    public UserDTO updateUser(Long id, UpdateUserFormDTO updateUserFormDTO) {
        User user = findUserById(id);
        userUpdater.updateUser(user, updateUserFormDTO);
        user = userRepository.save(user);
        return userDtoConverter.toDto(user);
    }

    /**
     * Deletes a user by its unique identifier.
     *
     * @param id the unique identifier of the user to be deleted
     * @throws UserNotFoundException if no user is found with the provided id
     */
    @Override
    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    /**
     * Retrieves a user by its unique identifier.
     * Throws {@link UserNotFoundException} if no user is found with the provided id.
     *
     * @param id the unique identifier of the user
     * @return the user entity
     * @throws UserNotFoundException if no user is found with the provided id
     */
    private User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
