package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {
   
    @Autowired
    private final avenida.avenida.Services.ProductoService productoService;

    
    public ProductoController(avenida.avenida.Services.ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable("id") Long idProducto) {
        Producto producto = productoService.get(idProducto);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(
            @PathVariable("id") Long idProducto, @RequestBody Producto productoActualizado) {
        Producto producto = productoService.updateProducto(idProducto, productoActualizado);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deliteProducto(@PathVariable("id") Long idProducto) {
        productoService.deleteProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //Creando la interfaz web
    //public ProductoController(ProductoService productoService) {
       // this.productoService = productoService;
    //}

    @GetMapping("/listado-producto")
    public String listarProducto(Model model) {
        List<Producto> producto = productoService.findAll();
        model.addAttribute("producto", producto);
        model.addAttribute("producto", new Producto()); // Añade esta línea
        return "/views/Producto/listado-producto";
    }
}
