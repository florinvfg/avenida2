package avenida.avenida.Services;



import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Repositorios.MesaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public List<Mesa> obtenerTodasLasMesas() {
        return mesaRepository.findAll();
    }

    public Mesa obtenerMesaPorId(Integer idMesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(idMesa);
        return optionalMesa.orElse(null);
    }

    public Mesa crearMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa actualizarMesa(Integer idMesa, Mesa mesaActualizada) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(idMesa);
        if (optionalMesa.isPresent()) {
            Mesa mesa = optionalMesa.get();
            mesa.setUbicacion(mesaActualizada.getUbicacion());
            mesa.setNumComensales(mesaActualizada.getNumComensales());
            return mesaRepository.save(mesa);
        } else {
            return null;
        }
    }

    public void eliminarMesa(Integer idMesa) {
        mesaRepository.deleteById(idMesa);
    }
}
