package avenida.avenida.Services;

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
public class EventsService {

    @Autowired
    private ComandaRepository ComandaRepository;

//guardar eventos
public Comanda save(Comanda event) {
    return ComandaRepository.saveAndFlush(event);
}

//actualizar Eventos
public Comanda updateEvent(UUID eventId, Comanda eventDetails) {
    // Encuentra el evento existente por su ID
    Comanda existingEvent = ComandaRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con el ID: " + eventId));
    
    // Actualiza los campos necesarios en el evento existente
    existingEvent.setName(eventDetails.getName());
    existingEvent.setDate(eventDetails.getDate());
    existingEvent.setHour(eventDetails.getHour());
    existingEvent.setLocationUrl(eventDetails.getLocationUrl());
    
    // Guarda y devuelve el evento actualizado
    return ComandaRepository.save(existingEvent);
}

// Encontrar todos los eventos
    public List<Comanda> findAll() {
        return ComandaRepository.findAll();
    }

// Encontrar evento por UUID en formato de cadena
    public Optional<Comanda> findByUuidString(String uuidString) {
        UUID uuid;
        try {
            uuid = UUID.fromString(uuidString);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("El UUID proporcionado no es válido: " + uuidString);
        }
        return ComandaRepository.findById(uuid);
    }

// Encontrar un evento por ID
    public Comanda findById(Long id) {
        Optional<Comanda> evento = ComandaRepository.findById(id);
        if (evento.isPresent()) {
            return evento.get();
        } else {
            throw new RuntimeException("Evento no encontrado con el ID: " + id);
        }
    }

    public Comanda updateEvent(Long id, Comanda comanda) {
        return null;
    }

    public Comanda update(Long id, Comanda comanda) {
        return null;
    }

    public void delete(Long id) {
    }
    
}