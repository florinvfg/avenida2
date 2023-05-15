package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Services.MesaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    public MesaService mesaService;


    @GetMapping
    public ResponseEntity<List<Mesa>> obtenerTodasLasMesas() {
        List<Mesa> mesas = mesaService.findAll();
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable int id) {
        Mesa mesa = mesaService.findById(id);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Mesa> createMesa(@ModelAttribute Mesa mesa) {
        Mesa nuevomesa = mesaService.save(mesa);
        return new ResponseEntity<>(nuevomesa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable int idmesa, @RequestBody Mesa mesaActualizado) {
        Mesa mesa = mesaService.update(idmesa, mesaActualizado);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public String verMesaDetalle(@PathVariable int id, Model model) {
        Mesa bicicleta = mesaService.findById(id);
        model.addAttribute("bicicleta", bicicleta);
        return "/views/Bicicletas/bicicleta-detalle";
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletemesa(@PathVariable int idmesa) {
        mesaService.delete(idmesa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// Creando la interfaz web
    public MesaController(MesaService mesaService) {
    this.mesaService = mesaService;
}

    @GetMapping("/listado-mesas")
    public String listarBicicletas(Model model) {
        List<Mesa> bicicletas = mesaService.findAll();
        model.addAttribute("bicicletas", bicicletas);
        model.addAttribute("bicicleta", new Mesa()); // Añade esta línea
        return "/views/Bicicletas/listado-bicicletas"; 
    }
}
