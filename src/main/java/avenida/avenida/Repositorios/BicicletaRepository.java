package avenida.avenida.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
    List<Bicicleta> findByMarca(String marca);
}