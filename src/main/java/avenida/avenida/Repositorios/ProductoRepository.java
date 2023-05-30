package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import avenida.avenida.Modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);

    Optional<Producto> findById(int id);

    List<Producto> findByPrecio(String precio);
}
