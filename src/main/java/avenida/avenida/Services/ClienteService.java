package avenida.avenida.Services;

import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.Cliente;
import avenida.avenida.Repositorios.ClienteRepository;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Encontrar todos los clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Encontrar un cliente por ID
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
    }

    // Guardar un nuevo cliente
    public Cliente save(Cliente cliente) {
        System.out.println("Guardando cliente: " + cliente.toString());
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente update(Long id, Cliente clienteDetails) {
        Cliente cliente = findById(id);
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellidos(clienteDetails.getApellidos());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setTelefono(clienteDetails.getTelefono());
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente por ID
    public void delete(Long id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

    // Controlar si un cliente existe por su email
    public boolean existsByEmail(String email) {
        return clienteRepository.existsByEmail(email);
    }
}