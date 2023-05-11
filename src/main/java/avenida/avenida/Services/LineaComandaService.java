package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avenida.avenida.Repositorios.LineaComandaRepository;
import java.util.List;
import avenida.avenida.Modelo.LineaComanda;

@Service
public class LineaComandaService {
   
    @Autowired
    private  LineaComandaRepository lineaComandaRepository;

    
    public LineaComandaService(LineaComandaRepository lineaComandaRepository) {
        this.lineaComandaRepository = lineaComandaRepository;
    }

 //   public List<LineaComanda> obtenerTodasLasLineasComanda() {
//        return lineaComandaRepository.obtenerTodasLasLineasComanda();
 //   }

    public LineaComanda obtenerLineaComandaPorId(int idLineaComanda) {
        return lineaComandaRepository.findById(idLineaComanda).orElse(null);
    }

    public LineaComanda save(LineaComanda lineaComanda) {
        return lineaComandaRepository.save(lineaComanda);
    }

    public LineaComanda actualizarLineaComanda(int idLineaComanda, LineaComanda lineaComandaDetails) {
        LineaComanda lineaComanda = obtenerLineaComandaPorId(idLineaComanda);
            lineaComanda.setComanda(lineaComandaDetails.getComanda());
            lineaComanda.setUnidadesProducto(lineaComandaDetails.getUnidadesProducto());
            lineaComanda.setProducto(lineaComandaDetails.getProducto());
            
            // Actualizar otros campos según sea necesario
            return lineaComandaRepository.save(lineaComanda);
    }

    public void eliminarLineaComanda(int idLineaComanda) {
        lineaComandaRepository.deleteById((long) idLineaComanda);
    }

    public static LineaComanda update(Object id, Object lineaComanda) {
        return null;
    }

    public LineaComanda crearLineaComanda(LineaComanda lineaComanda) {
        return null;
    }
}
