package avenida.avenida.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import avenida.avenida.Modelo.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    // Puedes agregar métodos personalizados para consultas específicas si es necesario
    // Por ejemplo, buscar contactos por nombre o por email
    
}
