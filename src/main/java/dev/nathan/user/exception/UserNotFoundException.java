package dev.nathan.user.exception;

/**
 * Custom exception thrown when a user is not found.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with ID " + id + " not found.");
    }
}
