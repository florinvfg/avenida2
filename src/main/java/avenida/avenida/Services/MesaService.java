package avenida.avenida.Services;



import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Repositorios.MesaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;


    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    public Mesa findById(int id) {
        Optional<Mesa> mesa = mesaRepository.findById(id);
        if (mesa.isPresent()) {
            return mesa.get();
        } else {
            throw new RuntimeException("mesa no encontrado con id: " + id);
        }
    }

    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa update(int id, Mesa mesaDetails) {
        Mesa mesa = findById(id);
        mesa.setNombre(mesaDetails.getNombre());
        mesa.setPrecio(mesaDetails.getPrecio());
        return mesaRepository.save(mesa);
    }

    public void delete(int id) {
        Mesa mesa = findById(id);
        mesaRepository.delete(mesa);
    }

    public Mesa get(Long idmesa) {
        return null;
    }

    public Mesa updatemesa(Long idmesa, Mesa mesaActualizado) {
        return null;
    }

    public void deletemesa(Long idmesa) {
    }

    public Mesa crearmesa(Mesa mesa) {
        return null;
    }
}


