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

import avenida.avenida.Modelo.Comanda;

@Controller
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    private avenida.avenida.Services.ComandaService ComandaService;

// Guardar un nuevo comanda
    @PostMapping("/create")
    public String createComanda(@ModelAttribute("newcomanda") Comanda event) {
        String hourString = event.getHour().toString();
        event.setHour(convertToLocalTime(hourString));       
// Crea un nuevo registro
        ComandaService.save(event);
        return "redirect:/Comanda/listado-comandas";
    }
    
// Actualizar comanda (POST)
    @PostMapping("/update-post")
    public String update(@ModelAttribute("comanda") Comanda event) {
        String hourString = event.getHour().toString();
        event.setHour(convertToLocalTime(hourString));

        ComandaService.save(event);
        return "redirect:/Comanda/listado-comanda";
    }

   

    // Obtener todos los comandas (GET)
    @GetMapping
    public ResponseEntity<List<Comanda>> getAllComanda() {
        List<Comanda> comanda = ComandaService.findAll();
        return new ResponseEntity<>(comanda, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getEventById(@PathVariable int id) {
        Comanda comanda = ComandaService.findById(id);
        return new ResponseEntity<>(comanda, HttpStatus.OK);
    }

// Editar un comanda por ID (GET)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Comanda event = ComandaService.findById(id);
        model.addAttribute("comanda", event);
        return "/views/Comanda/edit-comanda";
    }
    @GetMapping("/comanda-add")
    public String showComandaAddForm(Model model) {
        // Aquí puedes agregar lógica adicional si es necesario
        return "/views/Comanda/comanda-add"; // Ruta de la plantilla HTML
    }
// Método para listar comandas
    @GetMapping("/listado-comanda")
    public String listarcomandas(Model model) {
        List<Comanda> comanda = ComandaService.findAll();
        model.addAttribute("comanda", comanda);
        model.addAttribute("newcomanda", new Comanda()); // Añade esta línea aquí
        return "/views/Comanda/listado-comanda";
    }
 
    @GetMapping("/comanda-details/{id}")
    public String showEventDetails(@PathVariable int id, Model model) {
        Comanda comanda = ComandaService.findById(id);
        model.addAttribute("comanda", comanda);
        return "/views/Comanda/comanda-details";
    }

//Convertir hora
    private LocalTime convertToLocalTime(String hourString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hourString, formatter);
    }
}
