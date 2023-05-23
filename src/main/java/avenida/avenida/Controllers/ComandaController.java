package avenida.avenida.Controllers;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
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
import org.springframework.web.bind.annotation.RequestParam;

import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Modelo.Producto;
import avenida.avenida.Services.MesaService;
import avenida.avenida.Services.ProductoService;

@Controller
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    private avenida.avenida.Services.ComandaService ComandaService;
    private MesaService mesaService;
    private ProductoService productoService;
    
// Guardar una nueva comanda
@PostMapping("/create")
public String createComanda(@ModelAttribute("newcomanda") Comanda comanda) {
    String hourString = comanda.getHour().toString();
    comanda.setHour(convertToLocalTime(hourString));       
    ComandaService.save(comanda);
    return "redirect:/Comanda/comanda-listado";
}
    
// Actualizar comanda (POST)
    @PostMapping("/update-post")
    public String update(@ModelAttribute("comanda") Comanda comanda) {
        String hourString = comanda.getHour().toString();
        comanda.setHour(convertToLocalTime(hourString));

        ComandaService.save(comanda);
        return "redirect:/Comanda/comanda-listado";
    }

   

    // Obtener todas las comandas (GET)
    @GetMapping
    public ResponseEntity<List<Comanda>> getAllComanda() {
        List<Comanda> comanda = ComandaService.findAll();
        return new ResponseEntity<>(comanda, HttpStatus.OK);
    }
//Obtener una comanda por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getcomandaById(@PathVariable int id) {
        Comanda comanda = ComandaService.findById(id);
        return new ResponseEntity<>(comanda, HttpStatus.OK);
    }

// Editar una comanda por ID (GET)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Comanda comanda = ComandaService.findById(id);
        model.addAttribute("comanda", comanda);
        return "views/Comanda/edit-comanda";
    }
     @GetMapping("/comanda-add")
    public String showComandaAddForm(Model model) {
        // Aquí puedes agregar lógica adicional si es necesario
        return "views/Comanda/comanda-add"; // Ruta de la plantilla HTML
    }
// Método para listar comandas
@GetMapping("/comanda-listado")
public String getComandas(Model model) {
    List<Comanda> comandas = ComandaService.findAll(); // Asegúrate de obtener los datos correctos
    model.addAttribute("comandas", comandas);
    model.addAttribute("newComanda", new Comanda(null, null, null, null));
    return "views/Comanda/comanda-listado";
}
                                         
    // Aquí va la lógica para guardar la comanda en la base de datos
    // Puedes utilizar el servicio o repositorio correspondiente
    // Redirige a la página de listado de comandas



  
    // Otros métodos del controlador...

    

    @PostMapping("/save")
public String saveComanda(@RequestParam("mesaId") int mesaId,
                          @RequestParam("productoId") int productoId,
                          @RequestParam("date") LocalDate date,
                          @RequestParam("hour") LocalTime hour) {
    Mesa mesa = mesaService.getMesaById(mesaId);
    Producto producto = productoService.getProductoById(productoId);
    Comanda comanda = new Comanda(mesa, producto, date, hour);
    ComandaService.save(comanda); // Utiliza el servicio ComandaService para guardar la comanda
    return "redirect:/comanda/listado";
}





   /*  @GetMapping("/listado-comanda")
    public String listarcomandas(Model model) {
        List<Comanda> comanda = ComandaService.findAll();
        model.addAttribute("comanda", comanda);
        model.addAttribute("newcomanda", new Comanda()); // Añade esta línea aquí
        return "/views/Comanda/edit-comanda";
    }
     
    @GetMapping("/comandas")
    public String getComandas(Model model) {
        List<Comanda> comandas = ComandaService.getAllComandas(); // Asegúrate de obtener los datos correctos
        model.addAttribute("comandas", comandas);
        model.addAttribute("newComanda", new Comanda());
        return "comandas";
    }*/
     /* @GetMapping("/comanda-details/{id}")
    public String showcomandaDetails(@PathVariable("id") int id, Model model) {
        String uuidString = id.toString(); // Convertir UUID a String
        Optional<Comanda> comanda = ComandaService.findByUuidString(uuidString);
        model.addAttribute("comandao", comanda);
        return "/views/Comanda/edit-comanda";
    }*/ 
    

//Convertir hora
    private LocalTime convertToLocalTime(String hourString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hourString, formatter);
    }

    public avenida.avenida.Services.ComandaService getComandaService() {
        return ComandaService;
    }

    public void setComandaService(avenida.avenida.Services.ComandaService comandaService) {
        ComandaService = comandaService;
    }

    


    public MesaService getMesaService() {
        return getMesaService();
    }

    public void setMesaService(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    public ProductoService getProductoService() {
        return getProductoService();
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }
}
