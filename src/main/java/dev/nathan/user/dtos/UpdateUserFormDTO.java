package dev.nathan.user.dtos;

/**
 * DTO (Data Transfer Object) used for updating an existing user's data.
 * Contains the fields necessary to modify a user's information,
 * such as name, email, and CPF (Brazilian individual taxpayer ID).
 *
 * @param name  The user's name.
 * @param email The user's email.
 * @param cpf   The user's CPF (Cadastro de Pessoa Física).
 */
public record UpdateUserFormDTO(String name, String email, String cpf) {
}
