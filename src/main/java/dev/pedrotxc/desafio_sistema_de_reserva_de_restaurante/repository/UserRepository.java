package dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.repository;

import dev.pedrotxc.desafio_sistema_de_reserva_de_restaurante.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
