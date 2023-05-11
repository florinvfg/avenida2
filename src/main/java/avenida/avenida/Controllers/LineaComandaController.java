package avenida.avenida.Controllers;



import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Services.LineaComandaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineascomanda")
public class LineaComandaController {
    
    @Autowired
    private  LineaComandaService lineaComandaService;

    @GetMapping
    public ResponseEntity<List<LineaComanda>> obtenerTodasLasLineasComanda() {
        List<LineaComanda> lineasComanda = lineaComandaService.obtenerTodasLasLineasComanda();
        return new ResponseEntity<>(lineasComanda, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineaComanda> obtenerLineaComandaPorId(@PathVariable("id") int idLineaComanda) {
        LineaComanda lineaComanda = lineaComandaService.obtenerLineaComandaPorId(idLineaComanda);
        if (lineaComanda != null) {
            return new ResponseEntity<>(lineaComanda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LineaComanda> crearLineaComanda(@RequestBody LineaComanda lineaComanda) {
        LineaComanda nuevaLineaComanda = lineaComandaService.crearLineaComanda(lineaComanda);
        return new ResponseEntity<>(nuevaLineaComanda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineaComanda> updatemesalineaComanda(@PathVariable int id, @RequestBody LineaComanda lineaComanda, LineaComanda llineaComandaService) {
        LineaComanda updatedmesalineaComanda = lineaComandaService.update(id, lineaComanda);
        return new ResponseEntity<>(updatedmesalineaComanda, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLineaComanda(@PathVariable("id") int idLineaComanda) {
        lineaComandaService.eliminarLineaComanda(idLineaComanda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
