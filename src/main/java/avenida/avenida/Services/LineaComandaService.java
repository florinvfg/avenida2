package avenida.avenida.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Repositorios.LineaComandaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LineaComandaService {

    @Autowired
    private LineaComandaRepository lineaComandaRepository;

    public List<LineaComanda> findAll() {
        return lineaComandaRepository.findAll();
    }

    public LineaComanda findById(int id) {
        Optional<LineaComanda> optionallineaComanda = lineaComandaRepository.findById(id);
        if (optionallineaComanda.isPresent()) {
            return optionallineaComanda.get();
        } else {
            throw new RuntimeException("Reparación no encontrada con el ID: " + id);
        }
    }    

    public LineaComanda save(LineaComanda lineaComanda) {
        return lineaComandaRepository.save(lineaComanda);
    }

    public LineaComanda update(int id, LineaComanda lineaComanda) {
        LineaComanda existinglineaComanda = findById(id);
        existinglineaComanda.setUser(lineaComanda.getUser());
        existinglineaComanda.setproducto(lineaComanda.getproducto());
        existinglineaComanda.setFecha(lineaComanda.getFecha());
        existinglineaComanda.setFechaSalida(lineaComanda.getFechaSalida());
        existinglineaComanda.setDescripcion(lineaComanda.getDescripcion());
        existinglineaComanda.setImporte(lineaComanda.getImporte());
        return lineaComandaRepository.save(existinglineaComanda);
    }

    public void deleteById(int id) {
        LineaComanda existinglineaComanda = findById(id);
        lineaComandaRepository.delete(existinglineaComanda);
    }
}