package avenida.avenida.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import avenida.avenida.Modelo.Comanda;

public interface LineaComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByMesa(String mesa);
}