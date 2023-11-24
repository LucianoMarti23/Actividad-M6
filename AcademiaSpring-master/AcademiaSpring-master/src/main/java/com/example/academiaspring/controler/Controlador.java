package com.example.academiaspring.controler;

import org.springframework.ui.Model;
import com.example.academiaspring.interfaceService.IpersonaService;
import com.example.academiaspring.modelo.Persona;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    // Mapeo para mostrar la lista de personas
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    // Mapeo para mostrar el formulario de creación de persona
    @GetMapping("/crearPersonaForm")
    public String mostrarFormularioCreacion() {
        return "persona";
    }

    // Mapeo para procesar la creación de una nueva persona
    @PostMapping("/registro")
    public String registrarPersona(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "apellido") String apellido,
            Persona p) {
        p.setId(id);
        p.setName(nombre);
        p.setApellido(apellido);
        service.save(p);
        return "redirect:/listar";
    }

    // Mapeo para mostrar el formulario de eliminación de persona
    @GetMapping("/eliminarPersona")
    public String mostrarFormularioCreacionn() {
        return "eliminarPersonaForm";
    }

    // Mapeo para procesar la eliminación de una persona por su ID
    @PostMapping("/eliminar-Persona")
    public String eliminar(@RequestParam(name = "id") int id) {
        service.delete(id);
        return "redirect:/listar";
    }

    // Mapeo para mostrar el formulario de edición de persona por su ID
    @GetMapping("/editarPersona/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Optional<Persona> persona = service.listarId(id);

        if (persona.isPresent()) {
            model.addAttribute("persona", persona.get());
            return "editarPersonaForm";
        } else {
            // Manejar el caso en que la persona no existe con el ID dado
            return "redirect:/listar";
        }
    }

    // Mapeo para procesar la actualización de una persona por su ID
    @PostMapping("/editarPersona/{id}")
    public String actualizarPersona(@PathVariable int id, @ModelAttribute Persona persona) {
        Optional<Persona> personaExistente = service.listarId(id);

        if (personaExistente.isPresent()) {
            Persona personaActualizada = personaExistente.get();
            personaActualizada.setName(persona.getName());
            personaActualizada.setApellido(persona.getApellido());
            service.save(personaActualizada);
            return "redirect:/listar";
        } else {
            // Manejar el caso en que la persona no existe con el ID dado
            return "redirect:/listar";
        }
    }
}

