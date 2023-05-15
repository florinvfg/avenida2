package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.LineaComanda;

public interface LineaComandaRepository extends JpaRepository<Comanda,Integer> {
    List<Comanda> findByMesa(String mesa);

    Optional<LineaComanda> findById(int idLineaComanda);

   // LineaComanda saveAll(LineaComanda lineaComanda);

    LineaComanda save(LineaComanda lineaComanda);

    void deleteById(long idLineaComanda);

  //  List<LineaComanda> obtenerTodasLasLineasComanda();
}