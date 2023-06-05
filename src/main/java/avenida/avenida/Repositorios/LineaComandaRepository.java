package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Controllers.LineaComandaController;
import avenida.avenida.Modelo.LineaComanda;


public interface LineaComandaRepository extends JpaRepository<LineaComanda, Long> {

    LineaComanda save(LineaComandaController lineaComanda);

    Optional<LineaComanda> findById(int id);

    List<LineaComanda> findByComandaId(int comandaId);
    
}