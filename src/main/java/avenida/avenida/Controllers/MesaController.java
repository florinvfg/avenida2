package avenida.avenida.Controllers;

import java.util.List;
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

import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Services.MesaService;

@Controller
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesasService;

// Guardar una mesa nueva
    @PostMapping("/create")
    public String createMesa(@ModelAttribute("newMesa") Mesa mesa) {
        String hourString =mesa.getHour().toString();
        mesa.setHour(convertToLocalTime(hourString));       
// Crea un nuevo registro
        mesasService.save(mesa);
        return "redirect:/mesa/listado-mesa";
    }
    
// Actualizar mesao (POST)
    @PostMapping("/update-post")
    public String updatemesa(@ModelAttribute("mesao") Mesa mesa) {
        String hourString = mesa.getHour().toString();
        mesa.setHour(convertToLocalTime(hourString));

        mesasService.save(mesa);
        return "redirect:/mesa/listado-mesa";
    }
    
// Obtener todas las mesas (GET)
    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesas() {
        List<Mesa> mesa = MesaService.findAll();
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

// Obtener una mesa por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable int id) {
        Mesa mesa = MesaService.findById(id);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

// Editar una mesa por ID (GET)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Mesa mesa = MesaService.findById(id);
        model.addAttribute("mesa", mesa);
        return "/views/mesa/edit-mesa";
    }

// Método para listar mesaos
    @GetMapping("/listado-mesa")
    public String listarMesa(Model model) {
        List<Mesa> mesa = MesaService.findAll();
        model.addAttribute("mesa", mesa);
        model.addAttribute("mesa", new Mesa());
        model.addAttribute("newMesa", new Mesa()); // Añade esta línea aquí
        return "/views/Mesa/mesa-listado";
    }
 
    @GetMapping("/mesa-details/{id}")
    public String showMesaDetails(@PathVariable("id") int id, Model model) {
      
        Mesa mesa = MesaService.findById(id);
        model.addAttribute("mesa", mesa);
        return "/views/mesa/mesa-details";
    }

//Convertir hora
    private LocalTime convertToLocalTime(String hourString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hourString, formatter);
    }
}
