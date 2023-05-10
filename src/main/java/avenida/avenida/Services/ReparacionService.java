package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.Reparacion;
import avenida.avenida.Repositorios.ReparacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReparacionService {

    @Autowired
    private ReparacionRepository reparacionRepository;

    public List<Reparacion> findAll() {
        return reparacionRepository.findAll();
    }

    public Reparacion findById(Long id) {
        Optional<Reparacion> optionalReparacion = reparacionRepository.findById(id);
        if (optionalReparacion.isPresent()) {
            return optionalReparacion.get();
        } else {
            throw new RuntimeException("Reparación no encontrada con el ID: " + id);
        }
    }    

    public Reparacion save(Reparacion reparacion) {
        return reparacionRepository.save(reparacion);
    }

    public Reparacion update(Long id, Reparacion reparacion) {
        Reparacion existingReparacion = findById(id);
        existingReparacion.setUser(reparacion.getUser());
        existingReparacion.setBicicleta(reparacion.getBicicleta());
        existingReparacion.setFecha(reparacion.getFecha());
        existingReparacion.setFechaSalida(reparacion.getFechaSalida());
        existingReparacion.setDescripcion(reparacion.getDescripcion());
        existingReparacion.setImporte(reparacion.getImporte());
        return reparacionRepository.save(existingReparacion);
    }

    public void deleteById(Long id) {
        Reparacion existingReparacion = findById(id);
        reparacionRepository.delete(existingReparacion);
    }
}