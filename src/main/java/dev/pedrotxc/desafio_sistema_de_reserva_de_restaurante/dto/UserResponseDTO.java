package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.Role;

public record UserResponseDTO(Long id, String name, String email, Role role) {
}
