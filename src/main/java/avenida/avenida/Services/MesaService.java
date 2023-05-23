package avenida.avenida.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Repositorios.MesaRepository;

@Service
public class MesaService {

    private static MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        MesaService.mesaRepository = mesaRepository;
    }

//guardar mesaos
public static void save(Mesa mesa) {
    mesaRepository.saveAndFlush(mesa);
}

//actualizar mesa
public Mesa updatemesa(int mesaId, Mesa mesaDetails) {
    // Encuentra el mesao existente por su ID
    Mesa existingmesa = mesaRepository.findById(mesaId)
            .orElseThrow();
    
    // Actualiza los campos necesarios en el mesao existente
    existingmesa.setName(mesaDetails.getName());
    existingmesa.setDate(mesaDetails.getDate());
    existingmesa.setHour(mesaDetails.getHour());
    existingmesa.setLocationUrl(mesaDetails.getLocationUrl());
    
    // Guarda y devuelve el mesao actualizado
    return mesaRepository.save(existingmesa);
}

// Encontrar todos los mesaos
    public static List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

// Encontrar mesa por UUID en formato de cadena
    public List<Mesa> findByUuidString(String uuidString) {
        try {
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("El UUID proporcionado no es válido: " + uuidString);
        }
        return mesaRepository.findAll();
    }

// Encontrar un mesao por ID
    public static Mesa findById(int id) {
        Optional<Mesa> mesa = mesaRepository.findById(id);
        if (mesa.isPresent()) {
            return mesa.get();
        } else {
            throw new RuntimeException("mesao no encontrado con el ID: " + id);
        }
    }

    public Mesa getMesaById(int mesaId) {
        return null;
    }
    
}


