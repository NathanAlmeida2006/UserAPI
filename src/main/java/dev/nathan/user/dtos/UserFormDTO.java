package dev.nathan.user.dtos;

/**
 * DTO (Data Transfer Object) used to create a new user.
 * Contains the fields required to create a new user, such as name, email,
 * and CPF (Brazilian individual taxpayer ID).
 *
 * @param name  The user's name.
 * @param email The user's email.
 * @param cpf   The user's CPF (Cadastro de Pessoa Física).
 */
public record UserFormDTO(String name, String email, String cpf) {
}
