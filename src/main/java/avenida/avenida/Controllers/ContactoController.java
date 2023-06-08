package avenida.avenida.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import avenida.avenida.Modelo.Contacto;
import avenida.avenida.Services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/contacto")
public class ContactoController<FormularioContacto> implements ErrorController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public String mostrarPaginaContacto(Model model) {
        model.addAttribute("formularioContacto", new Object());
        return "views/Contacto/edit-contacto";
    }

    @PostMapping("/enviar")
    public String enviarFormularioContacto(@ModelAttribute("formularioContacto") FormularioContacto formulario, Model model) {
        if (formularioEsValido(formulario)) {
            contactoService.enviarMensaje(formulario);
            model.addAttribute("mensaje", "El mensaje se envió correctamente");
        } else {
            model.addAttribute("error", "Hubo un error al procesar el formulario");
        }
        return "contacto";
    }

    @GetMapping("/listado-contacto")
    public String mostrarListadoContactos(Model model) {
        List<Contacto> contactos = contactoService.obtenerContactos();
        model.addAttribute("contactos", contactos);
        model.addAttribute("contacto", new Contacto());
        model.addAttribute("newContacto", new Contacto()); // Añade esta línea aquí
        return "views/Contacto/listado-contacto";
    }

    @GetMapping("/{id}")
    public String mostrarDetallesContacto(@PathVariable("id") Long id, Model model) {
        Contacto contacto = contactoService.obtenerContactoPorId(id);
        model.addAttribute("contacto", contacto);
        return "views/Contacto/contacto-details";
    }

    @GetMapping("/edit/{id}")
    public String mostrarFormularioEdicionContacto(@PathVariable("id") Long id, Model model) {
        Contacto contacto = contactoService.obtenerContactoPorId(id);
        model.addAttribute("contacto", contacto);
        return "/views/Contacto/edit-contacto";
    }

    @PostMapping("/edit")
    public String guardarEdicionContacto(@ModelAttribute("contacto")FormularioContacto formularioContacto, Model model) {
        // Aquí puedes agregar la lógica para guardar los cambios del contacto editado
        // contactoService.guardarContacto(contacto);
        model.addAttribute("mensaje", "Los cambios se guardaron correctamente");
        return "contacto-details";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable("id") Long id, Model model) {
        // Aquí puedes agregar la lógica para eliminar el contacto
        // contactoService.eliminarContacto(id);
        model.addAttribute("mensaje", "El contacto se eliminó correctamente");
        return "redirect:/contacto/listado";
    }

    private boolean formularioEsValido(FormularioContacto formulario) {
        // Implementar la lógica de validación del formulario según tus requerimientos
        // Por ejemplo, validar que los campos requeridos estén presentes y sean válidos
        return true;
    }
   
   /*  @Override
    public String getErrorPath() {
        return "/error";
    }*/

    @RequestMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("error", "Ha ocurrido un error");
        return "error";
    }
}
