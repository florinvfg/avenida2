package avenida.avenida.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Repositorios.ComandaRepository;

//importar exceptions
import avenida.avenida.Exceptions.ResourceNotFoundException;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository ComandaRepository;

//guardar comandas
public Comanda save(Comanda comanda) {
    return ComandaRepository.saveAndFlush(comanda);
}

//actualizar comandas
public Comanda updatecomanda(int comandaId, Comanda comandaDetails) {
    // Encuentra el comanda existente por su ID
    Comanda existingcomanda = ComandaRepository.findById(comandaId)
            .orElseThrow(() -> new ResourceNotFoundException("comanda no encontrado con el ID: " + comandaId));
    
    // Actualiza los campos necesarios en el comanda existente
    existingcomanda.setName(comandaDetails.getName());
    existingcomanda.setDate(comandaDetails.getDate());
    existingcomanda.setHour(comandaDetails.getHour());
    existingcomanda.setLocationUrl(comandaDetails.getLocationUrl());
    
    // Guarda y devuelve el comanda actualizado
    return ComandaRepository.save(existingcomanda);
}

// Encontrar todos los comandas
    public List<Comanda> findAll() {
        return ComandaRepository.findAll();
    }

// Encontrar comanda por UUID en formato de cadena
   /*  public Optional<Comanda> findByUuidString(String uuidString) {
        UUID uuid;
        try {
            uuid = UUID.fromString(uuidString);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("El UUID proporcionado no es válido: " + uuidString);
        }
        return ComandaRepository.findById(uuid);
    }*/

// Encontrar un comanda por ID
    public Comanda findById(int id) {
        Optional<Comanda> comanda = ComandaRepository.findById(id);
        if (comanda.isPresent()) {
            return comanda.get();
        } else {
            throw new RuntimeException("comanda no encontrado con el ID: " + id);
        }
    }

   

    public Comanda update(int id, Comanda comanda) {
        return null;
    }

    public void delete(int id) {
    }

    public List<Comanda> getAllComandas() {
        return ComandaRepository.findAll();
    }

    public void saveComanda(int mesaId, int productoId, LocalDate date, LocalTime hour) {
    }

    public Optional<Comanda> findByUuidString(String uuidString) {
        return null;
    }
    
 public Comanda findById(UUID id) {
    Optional<Comanda> comanda = ComandaRepository.findById(id);
    if (comanda.isPresent()) {
        return comanda.get();
    } else {
        throw new RuntimeException("Evento no encontrado con el ID: " + id);
    }
  }
}