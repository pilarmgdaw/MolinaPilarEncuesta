package com.tarea1.tarea1.Controller;
import org.springframework.ui.Model;

import com.tarea1.tarea1.Model.Encuesta;
import com.tarea1.tarea1.Repository.EncuestaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importar de Spring
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller //Aqúi señalo que es un controlador
public class EncuestaController {

    @Autowired //asi inyecto las dependencias necesarias de manera automática
    private EncuestaRepository encuestaRepository;

    //Mostrar formulario
    @GetMapping("/encuesta")
    public String mostrarFormulario(Model model){
        model.addAttribute("encuesta", new Encuesta());
        return "formulario";
    }

    //Procesar formulario
    @PostMapping("/encuesta")
    public String guardarEncuesta(@Valid @ModelAttribute Encuesta encuesta, BindingResult result, Model model){
        if (result.hasErrors()){
            return "formulario";
        }
        encuestaRepository.save(encuesta);
        return "redirect:/encuestas";
    }
    // Listar encuestas
    @GetMapping("/encuestas")
    public String listarEncuestas(Model model) {
        List<Encuesta> encuestas = encuestaRepository.findAll();
        model.addAttribute("encuestas", encuestas);
        return "listado";
    }

    // Filtrar encuestas por nivel de satisfacción
    @GetMapping("/encuestas/filtrar")
    public String filtrarEncuestas(@RequestParam String nivelSatisfaccion, Model model) {
        List<Encuesta> encuestas = encuestaRepository.findByNivelSatisfaccion(nivelSatisfaccion);
        model.addAttribute("encuestas", encuestas);
        return "listado";
    }

    // Ver detalles de una encuesta
    @GetMapping("/encuesta/{id}")
    public String verEncuesta(@PathVariable Long id, Model model) {
        Encuesta encuesta = encuestaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Encuesta no encontrada: " + id));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = encuesta.getFechaInicioEstancia() != null ? encuesta.getFechaInicioEstancia().format(formatter) : "No disponible";
        model.addAttribute("fechaFormateada", fechaFormateada);
        model.addAttribute("encuesta", encuesta);
        return "detalles";
    }

    // Eliminar encuesta
    @PostMapping("/encuesta/{id}/eliminar")
    public String eliminarEncuesta(@PathVariable Long id) {
        encuestaRepository.deleteById(id);
        return "redirect:/encuestas";
    }
}
