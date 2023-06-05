package avenida.avenida.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Repositorios.ComandaRepository;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository; // Inyectar ComandaRepository

    // guardar comandas
    public Comanda save(Comanda comanda) {
        for (LineaComanda lineaComanda : comanda.getLineaComandas()) {
            // Aquí podemos realizar cualquier validación o configuración adicional en cada LineaComanda
        }
        return comandaRepository.save(comanda); // Uso la instancia inyectada para llamar al método save
    }

    // encontrar todas las comandas
    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    // encontrar una comanda por ID
    public Comanda findById(int id) {
        Optional<Comanda> comanda = comandaRepository.findById(id);
        if (comanda.isPresent()) {
            return comanda.get();
        } else {
            throw new RuntimeException("Comanda no encontrada con el ID: " + id);
        }
    }

   // eliminar una comanda por ID
    public void delete(int id) {
        comandaRepository.deleteById(id);
    }
}
