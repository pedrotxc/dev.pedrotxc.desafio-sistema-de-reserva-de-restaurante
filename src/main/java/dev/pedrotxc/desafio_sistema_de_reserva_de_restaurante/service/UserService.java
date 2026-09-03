package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.service;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.User;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserRequestDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserResponseDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.dto.UserUpdateDTO;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.exception.UserNotFoundException;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.mapper.UserMapper;
import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponseDto).toList();
    }

    public UserResponseDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponseDto)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Transactional
    public UserResponseDTO update(UserUpdateDTO userUpdateDTO, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userMapper.updateUser(user, userUpdateDTO);
        User userUpdated = userRepository.save(user);
        return userMapper.toResponseDto(userUpdated);
    }

    @Transactional
    public void delete(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.delete(user);
    }
}
