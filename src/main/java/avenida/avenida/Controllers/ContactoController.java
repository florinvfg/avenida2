package avenida.avenida.Controllers;

import avenida.avenida.Modelo.Contacto;
import avenida.avenida.Services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contacto")
    public String mostrarPaginaContacto(Model model) {
        model.addAttribute("formularioContacto", new Object());
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public <FormularioContacto> String enviarFormularioContacto(@ModelAttribute("formularioContacto") FormularioContacto formulario, Model model) {
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

    private <FormularioContacto> boolean formularioEsValido(FormularioContacto formulario) {
        // Implementar la lógica de validación del formulario según tus requerimientos
        // Por ejemplo, validar que los campos requeridos estén presentes y sean válidos
        return true;
    }
}
