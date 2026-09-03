package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(
        @Size(min = 3, max = 50, message = "Name should have between 3 and 50 characters")
        String name,
        @Size(max = 50)
        @Email(message = "Invalid format!")
        String email,
        @Size(max = 12)
        String password,
        @NotNull(message = "Role is required")
        Role role) {
}
