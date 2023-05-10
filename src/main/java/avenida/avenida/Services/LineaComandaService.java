package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import avenida.avenida.Repositorios.ReparacionRepository;

import java.util.List;
import java.util.Optional;


import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Repository.LineaComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineaComandaService {

    private final LineaComandaRepository lineaComandaRepository;

    @Autowired
    public LineaComandaService(LineaComandaRepository lineaComandaRepository) {
        this.lineaComandaRepository = lineaComandaRepository;
    }

    public List<LineaComanda> obtenerTodasLasLineasComanda() {
        return lineaComandaRepository.findAll();
    }

    public LineaComanda obtenerLineaComandaPorId(int idLineaComanda) {
        return lineaComandaRepository.findById(idLineaComanda).orElse(null);
    }

    public LineaComanda crearLineaComanda(LineaComanda lineaComanda) {
        return lineaComandaRepository.save(lineaComanda);
    }

    public LineaComanda actualizarLineaComanda(int idLineaComanda, LineaComanda lineaComandaActualizada) {
        Optional<LineaComanda> lineaComandaOptional = lineaComandaRepository.findById(idLineaComanda);
        if (lineaComandaOptional.isPresent()) {
            LineaComanda lineaComandaExistente = lineaComandaOptional.get();
            lineaComandaExistente.setComanda(lineaComandaActualizada.getComanda());
            lineaComandaExistente.setProducto(lineaComandaActualizada.getProducto());
            lineaComandaExistente.setUnidadesProducto(lineaComandaActualizada.getUnidadesProducto());
            // Actualizar otros campos según sea necesario
            return lineaComandaRepository.save(lineaComandaExistente);
        }
        return null;
    }

    public void eliminarLineaComanda(int idLineaComanda) {
        lineaComandaRepository.deleteById(idLineaComanda);
    }
}
