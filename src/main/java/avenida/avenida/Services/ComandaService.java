package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Repositorios.ComandaRepository;

import java.util.List;
import java.util.Optional;

@ComponentScan
@Service
public class ComandaService {

    @Autowired
    private ComandaRepository ComandaRepository;

    // Encontrar todas las Comandas
    public List<Comanda> findAll() {
        return ComandaRepository.findAll();
    }

    // Encontrar una Comanda por ID
    public Comanda findById(int id) {
        Optional<Comanda> Comanda = ComandaRepository.findById(id);
        if (Comanda.isPresent()) {
            return Comanda.get();
        } else {
            throw new RuntimeException("Comanda no encontrada con el ID: " + id);
        }
    }

    // Encontrar una Comanda por mesa
    public List<Comanda> findByMesa(String mesa) {
        // Aquí puedes implementar la lógica para filtrar las Comandas por mesa
        // Ejemplo: Utilizar un repositorio para buscar las Comandas con la mesa especificada
        return ComandaRepository.findByMesa(mesa);
    }

    // Guardar una Comanda
    public Comanda save(Comanda Comanda) {
        return ComandaRepository.save(Comanda);
    }

    // Actualizar una Comanda existente
    public Comanda update(int id, Comanda ComandaDetails) {
        Comanda Comanda = findById(id);

        
        Comanda.setIdMesa(ComandaDetails.getIdMesa());
        Comanda.setId(ComandaDetails.getId());
        Comanda.setLineaComanda(ComandaDetails.getLineaComanda());

        return ComandaRepository.save(Comanda);
    }

    // Eliminar una Comanda por ID
    public void delete(int id) {
        Comanda Comanda = findById(id);
        ComandaRepository.delete(Comanda);
    }
}