package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Services.BicicletaService;

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
    private BicicletaService bicicletaService;

// Obtener todas las bicicletas (GET)
    @GetMapping
    public ResponseEntity<List<Bicicleta>> getAllBicicletas() {
        List<Bicicleta> bicicletas = bicicletaService.findAll();
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

// Obtener una bicicleta por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> getBicicletaById(@PathVariable Long id) {
        Bicicleta bicicleta = bicicletaService.findById(id);
        return new ResponseEntity<>(bicicleta, HttpStatus.OK);
    }

// Obtener bicicletas por marca (GET)
    @GetMapping("/marca")
    public ResponseEntity<List<Bicicleta>> getBicicletasPorMarca(@RequestParam String marca) {
        List<Bicicleta> bicicletas = bicicletaService.findByMarca(marca);
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

//Obtener bicicleta para editar en html
    @GetMapping("/detalle/{id}")
    public String verBicicletaDetalle(@PathVariable Long id, Model model) {
        Bicicleta bicicleta = bicicletaService.findById(id);
        model.addAttribute("bicicleta", bicicleta);
        return "/views/Bicicletas/bicicleta-detalle";
    }

// Crear una nueva bicicleta (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Bicicleta> createBicicleta(@ModelAttribute Bicicleta bicicleta) {
    Bicicleta newBicicleta = bicicletaService.save(bicicleta);
    return new ResponseEntity<>(newBicicleta, HttpStatus.CREATED);
}  

// Actualizar una bicicleta existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> updateBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
        Bicicleta updatedBicicleta = bicicletaService.update(id, bicicleta);
        return new ResponseEntity<>(updatedBicicleta, HttpStatus.OK);
    }

// Eliminar una bicicleta por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBicicleta(@PathVariable Long id) {
        bicicletaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// Creando la interfaz web
    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @GetMapping("/listado-bicicletas")
    public String listarBicicletas(Model model) {
        List<Bicicleta> bicicletas = bicicletaService.findAll();
        model.addAttribute("bicicletas", bicicletas);
        model.addAttribute("bicicleta", new Bicicleta()); // Añade esta línea
        return "/views/Bicicletas/listado-bicicletas";
    }

}