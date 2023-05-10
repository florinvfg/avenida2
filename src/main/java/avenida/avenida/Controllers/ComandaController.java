package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Services.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    private EventsService ComandaService;

// Obtener todas las Comandas (GET)
    @GetMapping
    public ResponseEntity<List<Comanda>> getAllComandas() {
        List<Comanda> Comandas = ComandaService.findAll();
        return new ResponseEntity<>(Comandas, HttpStatus.OK);
    }

// Obtener una Comanda por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getComandaById(@PathVariable Long id) {
        Comanda Comanda = ComandaService.findById(id);
        return new ResponseEntity<>(Comanda, HttpStatus.OK);
    }

// Obtener Comandas por marca (GET)
   /*  @GetMapping("/marca")
    public ResponseEntity<List<Comanda>> getComandasPorMarca(@RequestParam String marca) {
        List<Comanda> Comandas = ComandaService.findByMarca(marca);
        return new ResponseEntity<>(Comandas, HttpStatus.OK);
    }*/

//Obtener Comanda para editar en html
    @GetMapping("/detalle/{id}")
    public String verComandaDetalle(@PathVariable Long id, Model model) {
        Comanda Comanda = ComandaService.findById(id);
        model.addAttribute("Comanda", Comanda);
        return "/views/Comandas/Comanda-detalle";
    }

// Crear una nueva Comanda (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Comanda> createComanda(@ModelAttribute Comanda Comanda) {
    Comanda newComanda = ComandaService.save(Comanda);
    return new ResponseEntity<>(newComanda, HttpStatus.CREATED);
}  

// Actualizar una Comanda existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Comanda> updateComanda(@PathVariable Long id, @RequestBody Comanda Comanda) {
        Comanda updatedComanda = ComandaService.update(id, Comanda);
        return new ResponseEntity<>(updatedComanda, HttpStatus.OK);
    }

// Eliminar una Comanda por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComanda(@PathVariable Long id) {
        ComandaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// Creando la interfaz web
    public ComandaController(EventsService ComandaService) {
        this.ComandaService = ComandaService;
    }

    @GetMapping("/listado-Comandas")
    public String listarComandas(Model model) {
        List<Comanda> Comandas = ComandaService.findAll();
        model.addAttribute("Comandas", Comandas);
        model.addAttribute("Comanda", new Comanda()); // Añade esta línea
        return "/views/Comandas/listado-Comandas";
    }

}