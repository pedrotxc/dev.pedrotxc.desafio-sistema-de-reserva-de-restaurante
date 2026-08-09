package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.controller;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserRequestDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserResponseDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-user")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO savedUser = userService.saveUser(userRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.id()).toUri();
        return ResponseEntity.created(uri).body(savedUser);
    }

}
