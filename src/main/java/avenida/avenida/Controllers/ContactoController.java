package avenida.avenida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import avenida.avenida.Services.ContactoService;

@Controller
public class ContactoController<FormularioContacto, Contacto> {

    @Autowired
    private ContactoService contactoService;
    
    @GetMapping("/contacto")
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    public String mostrarPaginaContacto(Model model) {
        model.addAttribute("formularioContacto", new FormularioContacto());
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarFormularioContacto(@ModelAttribute("formularioContacto") FormularioContacto formulario, Model model) {
        // Validar el formulario antes de procesarlo
        if (formularioEsValido(formulario)) {
            contactoService.enviarMensaje(formulario);
            model.addAttribute("mensaje", "El mensaje se envió correctamente");
        } else {
            model.addAttribute("error", "Hubo un error al procesar el formulario");
        }
        return "contacto";
    }

    @GetMapping("/contacto/listado")
    public String mostrarListadoContactos(Model model) {
        List<Contacto> contactos = contactoService.obtenerContactos();
        model.addAttribute("contactos", contactos);
        return "listado-contacto";
    }

    @GetMapping("/contacto/{id}")
    public String mostrarDetallesContacto(@PathVariable("id") Long id, Model model) {
        Contacto contacto = contactoService.obtenerContactoPorId(id);
        model.addAttribute("contacto", contacto);
        return "contacto-details";
    }

    // Otros métodos y lógica relacionados con el contacto

    private boolean formularioEsValido(FormularioContacto formulario) {
        // Implementar la lógica de validación del formulario según tus requerimientos
        // Por ejemplo, validar que los campos requeridos estén presentes y sean válidos
        return true;
    }
}


