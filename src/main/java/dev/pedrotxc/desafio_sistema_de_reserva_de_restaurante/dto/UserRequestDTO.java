package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 50, message = "Name should have between 3 and 50 characters")
        String name,
        @NotBlank(message = "Email is required")
        @Size(max = 50)
        @Email(message = "Invalid format!")
        String email,
        @NotBlank(message = "Password is requried")
        @Size(max = 12)
        String password,
        @NotNull(message = "Role is required")
        Role role) {
}
