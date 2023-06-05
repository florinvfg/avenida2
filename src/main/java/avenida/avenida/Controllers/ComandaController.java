package avenida.avenida.Controllers;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import avenida.avenida.Modelo.Comanda;
import avenida.avenida.Modelo.LineaComanda;
import avenida.avenida.Modelo.Mesa;
import avenida.avenida.Modelo.Producto;
import avenida.avenida.Modelo.User;
import avenida.avenida.Services.ComandaService;
import avenida.avenida.Services.LineaComandaService;
import avenida.avenida.Services.MesaService;
import avenida.avenida.Services.ProductoService;
import avenida.avenida.Services.UserService;
@Controller
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private LineaComandaService lineaComandaService;

    @GetMapping("/view-add")
    public String addComanda(Model model) {
    // Recuperar todos los objetos necesarios del servicio
        List<Mesa> mesas = mesaService.findAll();
        List<User> users = userService.findAll();
    
    // Crear una nueva comanda y una nueva línea de comanda y vincularlas
        Comanda comanda = new Comanda();
        comanda.setDate(new java.util.Date());
        comanda.setHour(java.time.LocalTime.now());
        LineaComanda lineaComanda = new LineaComanda();
        lineaComanda.setComanda(comanda);
        comanda.getLineaComandas().add(lineaComanda);

    // Añadir todos los atributos necesarios al modelo
        model.addAttribute("mesas", mesas);
        model.addAttribute("users", users);
        model.addAttribute("comanda", comanda);
        model.addAttribute("lineaComanda", lineaComanda);
    
    // Obtén la mesa seleccionada si existe
        Mesa selectedMesa = null;
        if (comanda.getMesa() != null) {
            selectedMesa = mesaService.findById(comanda.getMesa().getId());
        }
        model.addAttribute("selectedMesa", selectedMesa);
        return "views/Comanda/comanda-view-add";
    }
    
    @PostMapping("/add")
    public String saveComanda(@ModelAttribute("comanda") Comanda comanda) {
        double importeComanda = comanda.getLineaComandas().stream().mapToDouble(LineaComanda::getTotal).sum();
        comanda.setImporteComanda(importeComanda);
        comandaService.save(comanda);
        return "redirect:/comanda/listado";
    }

    @GetMapping("/listado")
    public String getComandas(Model model) {
        List<Comanda> comandas = comandaService.findAll();
        model.addAttribute("comandas", comandas);
        return "views/Comanda/comanda-listado";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Comanda comanda = comandaService.findById(id);
        Hibernate.initialize(comanda.getLineaComandas());
        List<LineaComanda> lineasComanda = lineaComandaService.findByComandaId(id);
        model.addAttribute("lineasComanda", lineasComanda);
        
        double importeComanda = comanda.getLineaComandas().stream().mapToDouble(LineaComanda::getTotal).sum();
        comanda.setImporteComanda(importeComanda);

        List<Producto> productos = productoService.findAll();
        System.out.println("Productos recuperados: " + productos);
        String productosJson = "[]";
        ObjectMapper mapper = new ObjectMapper();
        try {
            productosJson = mapper.writeValueAsString(productos);
        } catch (JsonProcessingException e) {
            System.err.println("Error al convertir productos a JSON: " + e.getMessage());
        }
        model.addAttribute("comanda", comanda);
        model.addAttribute("productos", productos);
        model.addAttribute("productosJson", productosJson);
        return "views/Comanda/comanda-view-edit";
    }

    @PostMapping("/edit/{id}")
        public String updateComanda(@PathVariable int id, @ModelAttribute("comanda") Comanda comanda) {
            double importeComanda = comanda.getLineaComandas().stream().mapToDouble(LineaComanda::getTotal).sum();
            comanda.setImporteComanda(importeComanda);
            comandaService.save(comanda);
            return "redirect:/comanda/listado";
        }

    @GetMapping("/delete/{id}")
    public String deleteComanda(@PathVariable int id) {
    comandaService.delete(id);
    return "redirect:/comanda/listado";
    }

}
