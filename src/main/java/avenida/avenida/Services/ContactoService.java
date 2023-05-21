package avenida.avenida.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ContactoService<Contacto> {
    private List<Contacto> listaContactos = new ArrayList<>();

    public List<Contacto> obtenerContactos() {
        return listaContactos;
    }

    public Contacto obtenerContactoPorId(Long id) {
        // Recorrer la lista de contactos y buscar el contacto por su ID
        for (Contacto contacto : listaContactos) {
            if (contacto.getId().equals(id)) {
                return contacto;
            }
        }
        return null; // Si no se encuentra el contacto, se devuelve null o se puede lanzar una excepción
    }

    public void agregarContacto(Contacto contacto) {
        // Generar un ID único para el contacto
        Long nuevoId = generarNuevoId();
        contacto.setId(nuevoId);
        // Agregar el contacto a la lista
        listaContactos.add(contacto);
    }

    public void actualizarContacto(Contacto contactoActualizado) {
        // Buscar el contacto en la lista por su ID
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getId().equals(contactoActualizado.getId())) {
                // Reemplazar el contacto actual con el contacto actualizado
                listaContactos.set(i, contactoActualizado);
                return;
            }
        }
        // Si no se encuentra el contacto, se puede lanzar una excepción o realizar otra acción
    }

    public void eliminarContacto(Long id) {
        // Buscar el contacto en la lista por su ID
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getId().equals(id)) {
                // Eliminar el contacto de la lista
                listaContactos.remove(i);
                return;
            }
        }
        // Si no se encuentra el contacto, se puede lanzar una excepción o realizar otra acción
    }

    private Long generarNuevoId() {
        // Generar un nuevo ID único para el contacto
        // Puedes implementar tu propia lógica para generar el ID, por ejemplo, utilizando un contador o un UUID
        // Aquí se usa una implementación simple con un ID incremental
        Long maxId = listaContactos.stream().map(Contacto::getId).max(Long::compare).orElse(0L);
        return maxId + 1;
    }

    public void enviarMensaje(FormularioContacto formulario) {
    }
}

