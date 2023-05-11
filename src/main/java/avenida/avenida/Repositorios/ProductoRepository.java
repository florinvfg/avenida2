package avenida.avenida.Repositorios;

import avenida.avenida.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}

