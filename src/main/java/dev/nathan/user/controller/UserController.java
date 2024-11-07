package dev.nathan.user.controller;

import dev.nathan.user.dtos.UpdateUserFormDTO;
import dev.nathan.user.dtos.UserDTO;
import dev.nathan.user.dtos.UserDetailsDTO;
import dev.nathan.user.dtos.UserFormDTO;
import dev.nathan.user.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsible for handling HTTP requests related to User operations.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Creates a new user based on the provided {@link UserFormDTO}.
     *
     * @param userFormDTO the user form data transfer object
     * @return the created {@link UserDTO} with an HTTP 201 CREATED status
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserFormDTO userFormDTO) {
        UserDTO createdUser = userService.createUser(userFormDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Retrieves a list of all registered users as {@link UserDetailsDTO}.
     *
     * @return a list of {@link UserDetailsDTO} with an HTTP 200 OK status
     */
    @GetMapping
    public ResponseEntity<List<UserDetailsDTO>> getAllUsers() {
        List<UserDetailsDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the user's ID
     * @return the {@link UserDetailsDTO} of the user with the specified ID with an HTTP 200 OK status
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable Long id) {
        UserDetailsDTO user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Updates an existing user with the provided {@link UpdateUserFormDTO}.
     *
     * @param id                the user's ID
     * @param updateUserFormDTO the updated user form data transfer object
     * @return the updated {@link UserDTO} with an HTTP 200 OK status
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UpdateUserFormDTO updateUserFormDTO) {
        UserDTO updatedUser = userService.updateUser(id, updateUserFormDTO);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the user's ID
     * @return a {@link ResponseEntity} with an HTTP 204 NO CONTENT status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}