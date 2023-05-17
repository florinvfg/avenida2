package avenida.avenida.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
