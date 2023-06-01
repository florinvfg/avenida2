package avenida.avenida.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Services.MesaService;

@Controller
@RequestMapping("/mesa")
public class MesaController {
    
    
    @Autowired
    private MesaService MesaService;
    
//boton de mesa listado para ir a añadir una mesa    
    @GetMapping("/agregarMesa")
    public String showAddForm(Model model) {
        model.addAttribute("newMesa", new Mesa()); 
        return "views/Mesa/agregarMesa";
    } 
    
//guardar mesa
    @PostMapping("/mesa/agregarMesa")
public String saveMesa(@ModelAttribute("newMesa") Mesa newMesa) {
    // Guardar la nueva mesa
    MesaService.save(newMesa);
    newMesa.setNumComensales(newMesa.getNumComensales());
    // Redirigir a la lista de mesas
    return "redirect:/mesa/listado-mesa";
}



// Obtener todas las mesas (GET)
    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesa() {
        List<Mesa> mesa = MesaService.findAll();
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

// Obtener una mesa por ID (GET)
    @GetMapping("id/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable int id) {
        Mesa mesa = MesaService.findById(id);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

// Editar una mesa por ID (GET)
    @GetMapping("edit-mesa/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Mesa mesa = MesaService.findById(id);
        model.addAttribute("mesa", mesa);
        return "views/Mesa/edit-mesa";
    }
    

// Método para listar mesas
@GetMapping("/listado-mesa")
public String listarMesa(Model model) {
    List<Mesa> listaMesas = MesaService.findAll();
    model.addAttribute("listaMesas", listaMesas);
    model.addAttribute("newMesa", new Mesa());
    return "views/Mesa/mesa-listado";
}

 
    @GetMapping("/mesa-details/id/{id}")
    public String showMesaDetails(@PathVariable("id") int id, Model model) {
      
        Mesa mesa = MesaService.findById(id);
        model.addAttribute("mesa", mesa);
        return "views/Mesa/mesa-details";
    }
    @PostMapping("/delete/{id}")
    public String deleteMesa(@PathVariable int id) {
        MesaService.deleteById(id);
        return "redirect:/mesa/listado-mesa";
    }

   
    
}

