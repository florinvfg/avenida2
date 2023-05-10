package avenida.avenida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import avenida.avenida.Modelo.Bicicleta;
import avenida.avenida.Modelo.Reparacion;
import avenida.avenida.Modelo.User;
import avenida.avenida.Repositorios.ReparacionRepository;
import avenida.avenida.Repositorios.UserRepository;
import avenida.avenida.Services.BicicletaService;
import avenida.avenida.Services.ReparacionService;
import avenida.avenida.Services.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

@Controller
@RequestMapping("/repairs")
public class ReparacionController {

    @Autowired
    private ReparacionService reparacionService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReparacionRepository reparacionRepository;

    @Autowired
    private BicicletaService bicicletaService;

    @PostMapping("/reparaciones")
    public String createReparacion(@ModelAttribute Reparacion reparacion) {
        reparacionService.save(reparacion);
        return "redirect:/repairs/listado-repairs";
    }
    
//cargar editar reparacion
    @GetMapping("/edit/{id}")
    public String showEditReparacionForm(@PathVariable("id") Long id, Model model) {
        try {
            Reparacion reparacion = reparacionService.findById(id);
            List<Bicicleta> bicicletas = bicicletaService.findAll();
            List<User> users = userService.findAll();

            model.addAttribute("reparacion", reparacion);
            model.addAttribute("bicicletas", bicicletas);
            model.addAttribute("users", users);

            return "views/Repairs/repair-edit";
        } catch (RuntimeException e) {
            return "error"; // Mostrar una página de error personalizada si la reparación no se encuentra
        }
    }

//añadir reparacion
    @PostMapping("/repairs/reparaciones")
    public String createReparacion(@ModelAttribute Reparacion reparacion, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        
        UUID userId = reparacion.getUser().getId();
        Optional<User> optionalUser = userRepository.findById(userId);
        
        if (!optionalUser.isPresent()) {
            return "error";
        }
        
        User user = optionalUser.get();
        reparacion.setUser(user);
        reparacionRepository.save(reparacion);
        return "success";
    }

//editar reparacion
    @PostMapping("/update-post")
    public String updateReparacion(@ModelAttribute("reparacion") Reparacion reparacion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Manejar errores de validación aquí
            return "views/Repairs/repair-edit";
        }

        reparacionService.save(reparacion);

        return "redirect:/repairs/listado-repairs"; // Redirige al usuario a la lista de reparaciones después de guardar los cambios
    }


    @GetMapping
    public String showRepairs(Model model) {
        List<Reparacion> reparaciones = reparacionService.findAll();
        model.addAttribute("reparaciones", reparaciones);
        return "repairs";
    }

    @GetMapping("/listado-repairs")
    public String listadoReparaciones(Model model) {
        List<Reparacion> reparaciones = reparacionService.findAll();
        List<User> users = userService.findAll();
        List<Bicicleta> bicicletas = bicicletaService.findAll();
        model.addAttribute("reparaciones", reparaciones);
        model.addAttribute("users", users);
        model.addAttribute("bicicletas", bicicletas);
        return "/views/Repairs/listado-repairs";
    }

    @GetMapping("/repair-add")
    public String addReparacion(Model model) {
        Reparacion reparacion = new Reparacion();
        List<Bicicleta> bicicletas = bicicletaService.findAll();
        List<User> users = userService.findAll();

        model.addAttribute("reparacion", reparacion);
        model.addAttribute("bicicletas", bicicletas);
        model.addAttribute("users", users);

        return "views/Repairs/repair-add";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reparacion> updateReparacion(@PathVariable Long id, @Valid @RequestBody Reparacion reparacion) {
        Reparacion updatedReparacion = reparacionService.update(id, reparacion);
        return new ResponseEntity<>(updatedReparacion, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public String deleteReparacion(@PathVariable Long id) {
        reparacionService.deleteById(id);
        return "redirect:/repairs/listado-repairs";
    }
    
}
