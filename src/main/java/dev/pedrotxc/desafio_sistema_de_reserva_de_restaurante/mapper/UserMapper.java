package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.mapper;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.User;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserRequestDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserResponseDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        user.setRole(userRequestDTO.role());
        return user;
    }

    public UserResponseDTO toResponseDto(User savedUser) {
        return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getRole());
    }

    public void updateUser(User user, UserUpdateDTO userUpdateDTO) {
        if (!(userUpdateDTO.name() == null)) {
            user.setName(userUpdateDTO.name());
        }
        if (!(userUpdateDTO.password() == null)) {
            user.setPassword(userUpdateDTO.password());
        }
        if (!(userUpdateDTO.email() == null)) {
            user.setEmail(userUpdateDTO.email());
        }
        if (!(userUpdateDTO.role() == null)) {
            user.setRole(userUpdateDTO.role());
        }

    }
}
