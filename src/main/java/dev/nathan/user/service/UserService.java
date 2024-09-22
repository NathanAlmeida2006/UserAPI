package dev.nathan.user.service;

import dev.nathan.user.dto.UserDTO;
import dev.nathan.user.dto.UserFormDTO;
import dev.nathan.user.dto.UpdateUserFormDTO;
import dev.nathan.user.entity.User;
import dev.nathan.user.repository.UserRepository;
import dev.nathan.user.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for managing users.
 * Handles the business logic for User operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserFormDTO form) {
        User user = form.toEntity();
        return new UserDTO(userRepository.save(user));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new UserDTO(user);
    }

    public UserDTO updateUser(Long id, UpdateUserFormDTO form) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setCpf(form.getCpf());
        return new UserDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);
    }
}
