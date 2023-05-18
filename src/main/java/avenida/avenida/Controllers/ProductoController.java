package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Producto;
import avenida.avenida.Services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//bicicleta
import java.util.List;

   
    @Controller
    @RequestMapping("/productos")
    public class ProductoController {
    
        @Autowired
        private ProductoService productoService;
    
    // Obtener todos los productos (GET)
        @GetMapping
        public ResponseEntity<List<Producto>> getAllproductos() {
            List<Producto> productos = productoService.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }
    
    // Obtener un producto por ID (GET)
        @GetMapping("/{id}")
        public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
            Producto producto = productoService.findById(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }
    
    // Obtener productos por marca (GET)
        @GetMapping("/marca")
        public ResponseEntity<List<Producto>> getProductosPorMarca(@RequestParam String marca) {
            List<Producto> productos = productoService.findByMarca(marca);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }
    
    //Obtener producto para editar en html
        @GetMapping("/detalle/{id}")
        public String verproductoDetalle(@PathVariable int id, Model model) {
            Producto producto = productoService.findById(id);
            model.addAttribute("producto", producto);
            return "/views/productos/producto-detalle";
        }
    
    // Crear una nueva producto (POST)
        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Producto> createproducto(@ModelAttribute Producto producto) {
        Producto newProducto = productoService.save(producto);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }  
    
    // Actualizar una producto existente (PUT)
        @PutMapping("/{id}")
        public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
            Producto updatedProducto = productoService.update(id, producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        }
    
    // Eliminar una producto por ID (DELETE)
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteproducto(@PathVariable int id) {
            productoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
    // Creando la interfaz web
        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }
    
        @GetMapping("/listado-productos")
        public String listarProductos(Model model) {
            List<Producto> productos = productoService.findAll();
            model.addAttribute("productos", productos);
            model.addAttribute("producto", new Producto()); // Añade esta línea
            return "/views/productos/listado-productos";
        }
 }