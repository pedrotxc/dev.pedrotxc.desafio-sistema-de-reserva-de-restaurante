package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.exception;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timeStamp, Integer status, String error, String message, String path) {

}
