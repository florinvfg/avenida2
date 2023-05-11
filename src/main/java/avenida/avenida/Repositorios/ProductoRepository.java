package avenida.avenida.Repositorios;

import avenida.avenida.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}

