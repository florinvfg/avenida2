package avenida.avenida.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Controlar si un cliente existe por su email
    boolean existsByEmail(String email);
}
