package avenida.avenida.Repositorios;

import avenida.avenida.Modelo.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
