package avenida.avenida.Controllers;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import avenida.avenida.Exceptions.ResourceNotFoundException;
import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Services.EventsService;

@Controller
@RequestMapping("/Comanda")
public class EventsController {

    @Autowired
    private Comanda ComandaService;

// Guardar un nuevo evento
    @PostMapping("/create")
    public String createEvent(@ModelAttribute("newEvento") Comanda event) {
        String hourString = event.getHour().toString();
        event.setHour(convertToLocalTime(hourString));       
// Crea un nuevo registro
        ComandaService.save(event);
        return "redirect:/Comanda/listado-eventos";
    }
    
// Actualizar evento (POST)
    @PostMapping("/update-post")
    public String updateEvent(@ModelAttribute("evento") Comanda event) {
        String hourString = event.getHour().toString();
        event.setHour(convertToLocalTime(hourString));

        ComandaService.save(event);
        return "redirect:/Comanda/listado-eventos";
    }
    
// Obtener todos los eventos (GET)
    @GetMapping
    public ResponseEntity<List<Comanda>> getAllComanda() {
        List<Comanda> eventos = ComandaService.findAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

// Obtener un evento por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getEventById(@PathVariable UUID id) {
        Comanda evento = ComandaService.findById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

// Editar un evento por ID (GET)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Comanda event = ComandaService.findByUuidString(id).orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con el ID: " + id));
        model.addAttribute("evento", event);
        return "/views/Comanda/edit-event";
    }

// Método para listar eventos
    @GetMapping("/listado-eventos")
    public String listarEventos(Model model) {
        List<Comanda> eventos = ComandaService.findAll();
        model.addAttribute("eventos", eventos);
        model.addAttribute("evento", new Comanda());
        model.addAttribute("newEvento", new Comanda()); // Añade esta línea aquí
        return "/views/Comanda/Comanda-list";
    }
 
    @GetMapping("/event-details/{id}")
    public String showEventDetails(@PathVariable("id") UUID id, Model model) {
        String uuidString = id.toString(); // Convertir UUID a String
        Optional<Comanda> event = ComandaService.findByUuidString(uuidString);
        model.addAttribute("evento", event);
        return "/views/Comanda/event-details";
    }

//Convertir hora
    private LocalTime convertToLocalTime(String hourString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hourString, formatter);
    }
}
