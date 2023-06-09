package avenida.avenida.Controllers;

import java.util.List;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
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

      // Instancia a Sanitizador de HTML import org.owasp.html.PolicyFactory; import org.owasp.html.Sanitizers;
      private static final PolicyFactory POLICY_FACTORY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
    
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
    newMesa.setLocationUrl(POLICY_FACTORY.sanitize(newMesa.getLocationUrl()));
    newMesa.setNumComensales(newMesa.getNumComensales());
    MesaService.save(newMesa);
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
    
 // Actualizar una mesa por ID (POST)
 @PostMapping("/edit-mesa/{id}")
 public String updateMesa(@PathVariable("id") int id, @ModelAttribute("mesa") Mesa mesa) {
     Mesa existingMesa = MesaService.findById(id);
     
     if (existingMesa == null) {
         // Manejar el caso cuando la mesa no existe
         return "redirect:/mesa/listado-mesa";
     }
     
     // Actualizar los atributos de la mesa existente
     existingMesa.setNumComensales(mesa.getNumComensales());
     // Actualizar más atributos si es necesario...
    existingMesa.setLocationUrl(POLICY_FACTORY.sanitize(mesa.getLocationUrl()));
     MesaService.save(existingMesa);
     
     // Redirigir a la lista de mesas
     return "redirect:/mesa/listado-mesa";
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

