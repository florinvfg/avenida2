package avenida.avenida.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Repositorios.MesaRepository;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    //guardar mesas
    public void save(Mesa mesa) {
        mesaRepository.saveAndFlush(mesa);
    }



//actualizar mesa
public Mesa updatemesa(int mesaId, Mesa mesaDetails) {
    // Encuentra el mesa existente por su ID
    Mesa existingmesa = mesaRepository.findById(mesaId)
            .orElseThrow();
    existingmesa.setLocationUrl(mesaDetails.getLocationUrl());
    
    // Guarda y devuelve el mesa actualizada
    return mesaRepository.save(existingmesa);
}

// Encontrar todas las mesas
    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }



// Encontrar un mesa por ID
    public Mesa findById(int id) {
        Optional<Mesa> mesa = mesaRepository.findById(id);
        if (mesa.isPresent()) {
            return mesa.get();
        } else {
            throw new RuntimeException("mesa no encontrada con el ID: " + id);
        }
    }

    public Mesa getMesaById(int mesaId) {
        return null;
    }

    public void deleteById(int id) {
        Mesa existingMesa = findById(id);
        mesaRepository.delete(existingMesa);
    }
  
}


