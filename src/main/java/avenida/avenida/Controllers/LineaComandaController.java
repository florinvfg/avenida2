package avenida.avenida.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Modelo.Producto;
import avenida.avenida.Repositorios.LineaComandaRepository;
import avenida.avenida.Services.LineaComandaService;
import avenida.avenida.Services.ProductoService;

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
@RequestMapping("/limeaComanda")
public class LineaComandaController {

    @Autowired
    private LineaComandaService lineaComandaService;

    @Autowired
    private avenida.avenida.Services.UserService userService;

    @Autowired
    private avenida.avenida.Repositorios.UserRepository userRepository;

    @Autowired
    private LineaComandaRepository lineaComandaRepository;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/lineaComanda")
    public String createLineaComanda(@ModelAttribute LineaComandaController lineaComanda) {
        lineaComandaService.save(lineaComanda);
        return "redirect:/LineaComanda/listado-lineaComanda";
    }
    
//cargar editar lineaComanda
    @GetMapping("/edit/{id}")
    public String showEditLineaComandaForm(@PathVariable("id") int id, Model model) {
        try {
            LineaComanda lineaComanda = lineaComandaService.findById(id);
            List<Producto> productos = productoService.findAll();
            List<avenida.avenida.Modelo.User> users = userService.findAll();

            model.addAttribute("lineaComanda", lineaComanda);
            model.addAttribute("productos", productos);
            model.addAttribute("users", users);

            return "views/LineaComanda/lineaComanda-edit";
        } catch (RuntimeException e) {
            return "error"; // Mostrar una página de error personalizada si la reparación no se encuentra
        }
    }

//añadir lineaComanda
    @PostMapping("/LineaComanda/lineaComanda")
    public String createLineaComanda(@ModelAttribute LineaComandaController lineaComanda, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        
        UUID userId = lineaComanda.getUser().getId();
        Optional<avenida.avenida.Modelo.User> optionalUser = userRepository.findById(userId);
        
        if (!optionalUser.isPresent()) {
            return "error";
        }
        
        avenida.avenida.Modelo.User user = optionalUser.get();
        lineaComanda.setUser(user);
        lineaComandaRepository.save(lineaComanda);
        return "success";
    }

private void setUser(avenida.avenida.Modelo.User user) {
    }

private avenida.avenida.Modelo.User getUser() {
        return null;
    }

    //editar lineaComanda
    @PostMapping("/update-post")
    public String updateLineaComanda(@ModelAttribute("lineaComanda") LineaComandaController lineaComanda, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Manejar errores de validación aquí
            return "views/LineaComanda/lineaComanda-edit";
        }

        lineaComandaService.save(lineaComanda);

        return "redirect:/lineaComanda/listado-lineaComanda"; 
        // Redirige al usuario a la lista de lineaComanda después de guardar los cambios"
    }


    @GetMapping
    public String showLineaComanda(Model model) {
        List<LineaComanda> lineaComanda = lineaComandaService.findAll();
        model.addAttribute("lineaComanda", lineaComanda);
        return "LineaComanda";
    }

    @GetMapping("/listado-LineaComanda")
    public String listadoLineaComanda(Model model) {
        List<LineaComanda> lineaComanda = lineaComandaService.findAll();
        List<avenida.avenida.Modelo.User> users = userService.findAll();
        List<Producto> productos = productoService.findAll();
        model.addAttribute("lineaComanda", lineaComanda);
        model.addAttribute("users", users);
        model.addAttribute("productos", productos);
        return "/views/LineaComanda/listado-lineaComanda";
    }

    @GetMapping("/lineaComanda-add")
    public String addLineaComanda(Model model) {
        LineaComandaController lineaComanda = new LineaComandaController();
        List<Producto> productos = productoService.findAll();
        List<avenida.avenida.Modelo.User> users = userService.findAll();

        model.addAttribute("lineaComanda", lineaComanda);
        model.addAttribute("productos", productos);
        model.addAttribute("users", users);

        return "views/LineaComanda/lineaComanda-add";
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineaComanda> updateLineaComanda(@PathVariable int id, @Valid @RequestBody LineaComanda lineaComanda) {
        LineaComanda updatedlineaComanda = lineaComandaService.update(id, lineaComanda);
        return new ResponseEntity<>(updatedlineaComanda, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public String deleteLineaComanda(@PathVariable int id) {
        lineaComandaService.deleteById(id);
        return "redirect:/LineaComanda/listado-lineaComanda";
    }
}