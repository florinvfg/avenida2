package avenida.avenida.Controllers;



import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.Producto;
import avenida.avenida.Services.ComandaService;
import avenida.avenida.Services.LineaComandaService;
import avenida.avenida.Services.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lineaComanda")
public class LineaComandaController {
  
    // Inyecciones de dependencias
        @Autowired
        private LineaComandaService lineaComandaService;
    
        @Autowired
        private ComandaService comandaService;  
    
        @Autowired
        private ProductoService productoService;
     // Instancia a Sanitizador de HTML import org.owasp.html.PolicyFactory; import org.owasp.html.Sanitizers;
     private static final PolicyFactory POLICY_FACTORY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

//añadir lineaComanda
        @PostMapping("/add")
        public String addLineaComanda(@ModelAttribute LineaComanda lineaComanda, @RequestParam("producto.id") int productId) {
            // Asegúrate de que el producto está presente en la base de datos
            Producto producto = productoService.findById(productId);
            if (producto == null) {
                // Maneja el caso en el que el producto no se encuentra
                return "redirect:/error";
            }
            lineaComanda.setProducto(producto);

            // Asegúrate de que la comanda está presente en la base de datos
            Comanda comanda = comandaService.findById(lineaComanda.getComanda().getId());
            if (comanda == null) {
                // Maneja el caso en que la comanda no se encuentra
                return "redirect:/error";
            }
            lineaComanda.setComanda(comanda);
            lineaComanda.setConcepto(POLICY_FACTORY.sanitize(lineaComanda.getConcepto()));
            lineaComanda.setEstado(POLICY_FACTORY.sanitize(lineaComanda.getEstado()));
            // Ahora puedes guardar la LineaComanda
            lineaComandaService.save(lineaComanda);

            return "redirect:/comanda/edit/" + lineaComanda.getComanda().getId();
        }

        @GetMapping("/delete/{id}")
        public String deleteLineaComanda(@PathVariable int id) {
            LineaComanda lineaComanda = lineaComandaService.findById(id);
            if (lineaComanda == null) {
                // Maneja el caso en el que la línea de comanda no se encuentra
                return "redirect:/error";
            }
            int comandaId = lineaComanda.getComanda().getId();
            lineaComandaService.deleteById(id);
            return "redirect:/comanda/edit/" + comandaId;
        }
    




}