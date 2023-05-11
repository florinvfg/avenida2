package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController<MesaService> {

    public MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public ResponseEntity<List<Mesa>> obtenerTodasLasMesas() {
        List<Mesa> mesas = ((Object) mesaService).obtenerTodasLasMesas();
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> obtenerMesaPorId(@PathVariable("id") Integer idMesa) {
        Mesa mesa = ((Object) mesaService).obtenerMesaPorId(idMesa);
        if (mesa != null) {
            return new ResponseEntity<>(mesa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Mesa> crearMesa(@RequestBody Mesa mesa) {
        Mesa nuevaMesa = ((Object) mesaService).crearMesa(mesa);
        return new ResponseEntity<>(nuevaMesa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> actualizarMesa(
            @PathVariable("id") Integer idMesa, @RequestBody Mesa mesaActualizada) {
        Mesa mesa = ((Object) mesaService).actualizarMesa(idMesa, mesaActualizada);
        if (mesa != null) {
            return new ResponseEntity<>(mesa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMesa(@PathVariable("id") Integer idMesa) {
        ((Object) mesaService).eliminarMesa(idMesa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
