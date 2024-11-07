package dev.nathan.user.service.exceptions;

/**
 * Custom exception class for handling user-related errors.
 * This exception is a subclass of {@link RuntimeException}.
 *
 * @see RuntimeException
 */
public class UserException extends RuntimeException {

    /**
     * Constructs a new {@link UserException} with the specified detail message.
     *
     * @param message the detail message which is saved for later retrieval by the {@link Throwable#getMessage()} method.
     */
    public UserException(String message) {
        super(message);
    }
}
