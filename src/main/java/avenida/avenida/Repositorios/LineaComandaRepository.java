package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.LineaComanda;

public interface LineaComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByMesa(String mesa);

    Optional<Comanda> findById(int idLineaComanda);

    LineaComanda saveAll(LineaComanda lineaComanda);
}