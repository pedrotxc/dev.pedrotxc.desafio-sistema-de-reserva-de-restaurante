package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.controller;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserRequestDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserResponseDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.exception.ErrorResponse;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.exception.UserNotFoundException;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.service.UserService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDTO> saveUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO savedUser = userService.saveUser(userRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.id()).toUri();
        return ResponseEntity.created(uri).body(savedUser);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UserResponseDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

}
