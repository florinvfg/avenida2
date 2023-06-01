package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Producto;
import avenida.avenida.Services.ProductoService;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    @RequestMapping("/producto")
    public class ProductoController {
    
        @Autowired
        private ProductoService productoService;

        //ir a ver todos los productos
        @GetMapping("/listado-producto")
        public String listarProductos(Model model) {
            List<Producto> productos = productoService.findAll();
            model.addAttribute("productos", productos);
            model.addAttribute("producto", new Producto()); // Añade esta línea
            return "/views/Producto/listado-producto";
        }

    //ir a la ventana de Guardar producto
     @GetMapping("/agregarProducto")
    public String agregarProducto(Model model) {
        // Guardar un nuevo producto
        model.addAttribute("newProducto", new Producto());
        // Redirigir a la lista de productos
        return "/views/Producto/agregarProducto";
    }
   //guardar producto
  /*  @PostMapping("/producto/agregaProducto")
   public String saveProducto(@ModelAttribute("newProducto") Producto newProducto) {
       // Guardar un nuevo producto
       ProductoService.save(newProducto);
       newProducto.setNombre(newProducto.getNombre());
       // Redirigir a la lista de mesas
       return "redirect:/producto/listado-producto";
   }*/
  


   @PostMapping("/agregaProducto")
   public String saveProducto(@ModelAttribute("newProducto") Producto newProducto) {
       // Guardar un nuevo producto
       productoService.save(newProducto);
       // Redirigir a la lista de mesas
       return "redirect:/producto/listado-producto";
   }
   

    // Obtener todos los productos (GET)
        @GetMapping
        public ResponseEntity<List<Producto>> getAllProductos() {
            List<Producto> productos = productoService.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }
    
    // Obtener un producto por ID (GET)
        @GetMapping("/{id}")
        public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
            Producto producto = productoService.findById(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }
    
    // Obtener producto por nombre (GET)
        @GetMapping("/nombre")
        public ResponseEntity<List<Producto>> getProductosPorNombre(@RequestParam String nombre) {
            List<Producto> productos = productoService.findByNombre(nombre);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }
    
    //Obtener producto para editar en html
        @GetMapping("/edit-producto/{id}")
        public String verproductoDetalle(@PathVariable int id, Model model) {
            Producto producto = productoService.findById(id);
            model.addAttribute("producto", producto);
            return "/views/Producto/edit-producto";
        }
    
   /*  // Crear un nuevo producto (POST)
        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Producto> createProducto(@ModelAttribute Producto producto) {
        Producto newProducto = ProductoService.save(producto);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }  
    */
    @PostMapping("/edit-producto/{id}")
    public String updateProducto(@PathVariable int id, @ModelAttribute("producto") Producto producto) {
        producto.setId(id); // Establece el ID del producto
        productoService.save(producto); // Guarda los cambios en el producto
        return "redirect:/producto/listado-producto";
    }
    // Actualizar un producto existente (PUT)
       /*  @PutMapping("/{id}")
        public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
            Producto updatedProducto = productoService.update(id, producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        }*/
    
    // Eliminar una producto por ID (DELETE)
        @PostMapping("/delete/{id}")
        public String deleteProducto(@PathVariable int id) {
            productoService.delete(id);
            return "redirect:/producto/listado-producto";
        }
    
    // Creando la interfaz web
        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }

 }