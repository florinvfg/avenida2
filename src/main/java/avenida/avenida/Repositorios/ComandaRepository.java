package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import avenida.avenida.Modelo.Comanda;


public interface ComandaRepository extends JpaRepository<Comanda, UUID> {
   Optional<Comanda> findById(int id);

List<Comanda> findByMesa(String mesa);
  }

  
  

