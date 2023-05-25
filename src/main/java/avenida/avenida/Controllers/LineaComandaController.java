package avenida.avenida.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Modelo.Producto;
import avenida.avenida.Modelo.User;
import avenida.avenida.Repositorios.LineaComandaRepository;
import avenida.avenida.Repositorios.UserRepository;
import avenida.avenida.Services.LineaComandaService;
import avenida.avenida.Services.ProductoService;
import avenida.avenida.Services.UserService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//reparaciones
import javax.validation.Valid;

@Controller
@RequestMapping("/lineaComanda")
public class LineaComandaController {
  
    
        @Autowired
        private LineaComandaService lineaComandaService;
    
        @Autowired
        private UserService userService;
    
        @Autowired
        private UserRepository userRepository;
    
        @Autowired
        private LineaComandaRepository lineaComandaRepository;
    
        @Autowired
        private ProductoService productoService;
    
        @PostMapping("/lineaComanda")
        public String createLineaComanda(@ModelAttribute LineaComanda lineaComanda) {
            lineaComandaService.save(lineaComanda);
            return "redirect:/LineaComanda/listado-lineaComanda";
        }
    
        // cargar editar lineaComanda
        @GetMapping("/edit/{id}")
        public String showEditLineaComandaForm(@PathVariable("id") int id, Model model) {
            try {
                LineaComanda lineaComanda = lineaComandaService.findById(id);
                List<Producto> productos = productoService.findAll();
                List<User> users = userService.findAll();
    
                model.addAttribute("lineaComanda", lineaComanda);
                model.addAttribute("productos", productos);
                model.addAttribute("users", users);
    
                return "views/LineaComanda/lineaComanda-edit";
             } catch (RuntimeException e) {
                return "erorr"; // Mostrar una página de error personalizada si la reparación no se encuentra
            } 
        }
        
    
        // añadir lineaComanda
        @PostMapping("/lineaComanda/lineaComanda")
        public String createLineaComanda(@ModelAttribute LineaComanda lineaComanda, BindingResult result) {
            if (result.hasErrors()) {
                return "lineaComanda";
            }
    
            UUID userId = lineaComanda.getUser().getId();
            Optional<User> optionalUser = userRepository.findById(userId);
    
            if (!optionalUser.isPresent()) {
                return "error";
            }
    
            User user = optionalUser.get();
            lineaComanda.setUser(user);
            lineaComandaRepository.save(lineaComanda);
            return "success";
        }
    
        // editar lineaComanda
        @PostMapping("/update-post")
        public String updateLineaComanda(@ModelAttribute("lineaComanda") LineaComanda lineaComanda, BindingResult result, Model model) {
            if (result.hasErrors()) {
                // Manejar errores de validación aquí
                return "views/LineaComanda/lineaComanda-edit";
            }
    
            lineaComandaService.save(lineaComanda);
    
            return "redirect:/LineaComanda/listado-lineaComanda";
            // Redirige al usuario a la lista de lineaComanda después de guardar los cambios
        }
    
        @GetMapping
        public String showLineaComanda(Model model) {
            List<LineaComanda> lineaComanda = lineaComandaService.findAll();
            model.addAttribute("lineaComanda", lineaComanda);
            return "lineaComanda";
        }
    
        @GetMapping("/listado-lineaComanda")
        public String listadoLineaComanda(Model model) {
            List<LineaComanda> lineaComanda = lineaComandaService.findAll();
            List<User> users = userService.findAll();
            List<Producto> productos = productoService.findAll();
            model.addAttribute("lineaComanda", lineaComanda);
            model.addAttribute("users", users);
            model.addAttribute("productos", productos);
            return "views/LineaComanda/listado-lineaComanda";
        }
        @GetMapping("/lineaComanda-add")
        public String addLineaComanda(Model model) {
            LineaComanda lineaComanda = new LineaComanda();
            List<Producto> productos = productoService.findAll();
            List<User> users = userService.findAll();
    
            model.addAttribute("lineaComanda", lineaComanda);
            model.addAttribute("productos", productos);
            model.addAttribute("users", users);
    
            return "views/lineaComanda/LineaComanda/lineaComanda-add";
        }
        @PutMapping("/{id}")
    public ResponseEntity<LineaComanda> updateLineaComanda(@PathVariable int id, @Valid @RequestBody LineaComanda lineaComanda) {
        LineaComanda updatedLineaComanda = lineaComandaService.update(id, lineaComanda);
        return new ResponseEntity<>(updatedLineaComanda, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public String deleteLineaComanda(@PathVariable int id) {
        lineaComandaService.deleteById(id);
        return "redirect:/LineaComanda/listado-lineaComanda";
    }
}