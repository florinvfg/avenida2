package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avenida.avenida.Repositorios.LineaComandaRepository;
import java.util.List;
import java.util.Optional;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.LineaComanda;

@Service
public class LineaComandaService {

    private final LineaComandaRepository lineaComandaRepository;

    @Autowired
    public LineaComandaService(LineaComandaRepository lineaComandaRepository) {
        this.lineaComandaRepository = lineaComandaRepository;
    }

    public List<Comanda> obtenerTodasLasLineasComanda() {
        return lineaComandaRepository.findAll();
    }

    public Comanda obtenerLineaComandaPorId(int idLineaComanda) {
        return lineaComandaRepository.findById(idLineaComanda).orElse(null);
    }

    public LineaComanda crearLineaComanda(LineaComanda lineaComanda) {
        return lineaComandaRepository.saveAll(lineaComanda);
    }

    public Comanda actualizarLineaComanda(int idLineaComanda, LineaComanda lineaComandaActualizada) {
        Optional<Comanda> lineaComandaOptional = lineaComandaRepository.findById(idLineaComanda);
        if (lineaComandaOptional.isPresent()) {
            Comanda lineaComandaExistente = lineaComandaOptional.get();
            lineaComandaExistente.setImporteComanda(lineaComandaActualizada.getComanda());
            lineaComandaExistente.setProducto(lineaComandaActualizada.getProducto());
            
            // Actualizar otros campos según sea necesario
            return lineaComandaRepository.save(lineaComandaExistente);
        }
        return null;
    }

    public void eliminarLineaComanda(int idLineaComanda) {
        lineaComandaRepository.deleteById((long) idLineaComanda);
    }

    public static LineaComanda update(Object id, Object lineaComanda) {
        return null;
    }
}
