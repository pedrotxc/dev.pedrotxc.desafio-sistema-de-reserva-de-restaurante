package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.Role;

public record UserRequestDTO(String name, String email, String password, Role role) {
}
