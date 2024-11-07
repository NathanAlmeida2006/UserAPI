package dev.nathan.user.dtos;

/**
 * DTO (Data Transfer Object) that represents basic user data.
 * Contains summarized information about a user, including ID, name,
 * email, and CPF.
 *
 * @param id    The user's unique identifier.
 * @param name  The user's name.
 * @param email The user's email.
 * @param cpf   The user's CPF (Cadastro de Pessoa Física).
 */
public record UserDTO(Long id, String name, String email, String cpf) {
}
