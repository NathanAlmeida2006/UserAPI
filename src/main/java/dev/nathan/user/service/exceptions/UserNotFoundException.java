package dev.nathan.user.service.exceptions;

/**
 * Custom exception class for handling situations where a user is not found.
 * This exception extends {@link UserException} to indicate a specific type of user-related error.
 *
 * @see UserException
 */
public class UserNotFoundException extends UserException {

    /**
     * Constructs a new {@link UserNotFoundException} with the specified detail message.
     *
     * @param message the detail message which is saved for later retrieval by the {@link Throwable#getMessage()} method.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
