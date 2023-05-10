package avenida.avenida.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import avenida.avenida.Modelo.Reparacion;


public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {
    
}