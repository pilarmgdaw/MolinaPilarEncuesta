package com.tarea1.tarea1.Controller;

import ch.qos.logback.core.model.Model;
import com.tarea1.tarea1.Model.Encuesta;
import com.tarea1.tarea1.Repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String guardarEncuesta(Model model, Encuesta encuesta){}
        ME HE QUEDADO POR AQUI
}
