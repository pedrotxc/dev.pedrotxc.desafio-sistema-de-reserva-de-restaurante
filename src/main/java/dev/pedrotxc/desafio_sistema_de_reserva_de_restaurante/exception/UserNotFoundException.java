package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
