package avenida.avenida.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import avenida.avenida.Modelo.Cliente;
import avenida.avenida.Services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

// Obtener todos los clientes
    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

// obtener todos los clientes api en JSON
    @GetMapping("/clientes-json")
    public ResponseEntity<List<Cliente>> getAllClientesJson() {
    List<Cliente> clientes = clienteService.findAll();
    return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

// Obtener un cliente por ID
    @GetMapping("/{id}")
    public String getClienteById(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente-detalle";
    }

// Obtener un cliente por ID con ruta /api y @ResponseBody
    @ResponseBody
    @Transactional
    @GetMapping("/{id}/api")
    public ResponseEntity<Cliente> getClienteByIdApi(@PathVariable Long id) {
        System.out.println("Buscando cliente con ID: " + id); // Agregar esta línea
        Cliente cliente = clienteService.findById(id);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

// Crear un nuevo cliente comprobando email, devolviendo mensaje por JSON
    @PostMapping(path = "/api", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCliente(@Valid @RequestBody Cliente cliente) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (clienteService.existsByEmail(cliente.getEmail())) {
            responseHeaders.set("X-Error-Message", "Ya existe un cliente con el correo electrónico proporcionado.");
            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CONFLICT);
        } else {
            Cliente newCliente = clienteService.save(cliente);
            return new ResponseEntity<>(newCliente, responseHeaders, HttpStatus.CREATED);
        }
    }

// Actualizar un cliente existente
    @PutMapping("/api/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente updatedCliente) {
        System.out.println("Actualizando cliente con ID: " + id); // Agregar esta línea
        Cliente currentCliente = clienteService.findById(id);
        if (currentCliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCliente.setNombre(updatedCliente.getNombre());
        currentCliente.setApellidos(updatedCliente.getApellidos());
        currentCliente.setEmail(updatedCliente.getEmail());
        currentCliente.setTelefono(updatedCliente.getTelefono());
        
        Cliente savedCliente = clienteService.save(currentCliente);
        
        if (savedCliente == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedCliente, HttpStatus.OK);
    }
    
// Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//Habilitar registro errores detallados en las respuestas de error:
    @ControllerAdvice
    public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        String bodyOfResponse = "Error interno del servidor: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
}
