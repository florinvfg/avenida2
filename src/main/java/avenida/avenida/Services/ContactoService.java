package avenida.avenida.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import avenida.avenida.Modelo.Contacto;

@Service
public class ContactoService {
    private List<Contacto> listaContactos = new ArrayList<>();

    public List<Contacto> obtenerContactos() {
        return listaContactos;
    }

    public Contacto obtenerContactoPorId(Long id) {
        for (Contacto contacto : listaContactos) {
            if (contacto.getId().equals(id)) {
                return contacto;
            }
        }
        return null;
    }

    public void agregarContacto(Contacto contacto) {
        Long nuevoId = generarNuevoId();
        contacto.setId(nuevoId);
        listaContactos.add(contacto);
    }

    public void actualizarContacto(Contacto contactoActualizado) {
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getId().equals(contactoActualizado.getId())) {
                listaContactos.set(i, contactoActualizado);
                return;
            }
        }
    }

    public void eliminarContacto(Long id) {
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getId().equals(id)) {
                listaContactos.remove(i);
                return;
            }
        }
    }

    private Long generarNuevoId() {
        Long maxId = listaContactos.stream().map(Contacto::getId).max((arg0, arg1) -> Long.compare(arg0, arg1)).orElse(0L);
        return maxId + 1;
    }

    public <FormularioContacto> void enviarMensaje(FormularioContacto formulario) {
    }

   /*  public void enviarMensaje(FormularioContacto formulario) {
        // Lógica para enviar el mensaje del formulario de contacto
        // Puedes acceder a los atributos del formulario, como formulario.getNombre(), formulario.getEmail(), etc.
    }*/
}


