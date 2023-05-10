package avenida.avenida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import avenida.avenida.Modelo.User;
import avenida.avenida.Services.UserService;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller //se utiliza para construir aplicaciones web y devuelve vistas.
//@RestController // es una versión especializada de @Controller que se utiliza para construir servicios RESTful y devuelve directamente objetos JSON. incompatible con @Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

//metodo dar formato fechas para Modal
    public String formatLocalDateTime(final LocalDateTime dateTime) {
        if (dateTime == null) {
            return "";
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return dateTime.format(formatter);
    }

// Crear un nuevo user (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<avenida.avenida.Modelo.User> createUser(@ModelAttribute final User user) {
    final LocalDateTime currentDateTime = LocalDateTime.now();
    user.setUserDateConsent(currentDateTime);
    user.setUserCreatedAt(currentDateTime);
    final User newUser = userService.save(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
}

// Actualizar un user existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable final UUID id, @RequestBody final User user) {
    final User updatedUser = userService.update(id, user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}

// Obtener todos los Usuarios (GET)
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

// Obtener un user por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final UUID id) {
        final User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//Obtener user para editar en html
    @GetMapping("/detalle/{id}")
    public String verUserDetalle(@PathVariable final UUID id, final Model model) {
        final User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userDateConsentFormatted", formatLocalDateTime(user.getUserDateConsent()));
        model.addAttribute("userCreatedAtFormatted", formatLocalDateTime(user.getUserCreatedAt()));
        return "/views/Users/user-detail";
    }

// Eliminar un User por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// Creando la interfaz web
    public UserController(final UserService userService) {
        this.userService = userService;
    }

//obtener listado de usuarios
    @GetMapping("/listado-users")
    public String listarUsers(final Model model) {
        final List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // Añade esta línea
        return "/views/Users/listado-users";
    }
}