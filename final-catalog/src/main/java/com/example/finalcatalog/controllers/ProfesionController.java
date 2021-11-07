package com.example.finalcatalog.controllers;

import com.example.finalcatalog.models.entities.Profesion;
import com.example.finalcatalog.services.IProfesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/views/profesiones")
public class ProfesionController {


    final IProfesionService profesionService;

    @Autowired
    public ProfesionController(
            IProfesionService profesionService
    ){
        this.profesionService = profesionService;
    }

    @GetMapping("/")
    public String listar(Model model){

        List<Profesion> profesiones = profesionService.listar();

        model.addAttribute("titulo", "Lista de profesiones");
        model.addAttribute("profesiones", profesiones);

        return  "/views/profesiones/listar";
    }

    @GetMapping("/nuevo")
    public String crear(Model model){

        Profesion profesion = new Profesion();

        model.addAttribute("titulo", "Agregar nueva profesión");
        model.addAttribute("profesion", profesion);

        return "/views/profesiones/crear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Profesion profesion, RedirectAttributes attribute) {

        profesionService.guardar(profesion);
        attribute.addFlashAttribute("success", "Profesión guardada con éxito");
        return "redirect:/views/profesiones/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){

        Profesion profesion = profesionService.buscarPorId(id);

        model.addAttribute("titulo", "Formulario: Editar profesión");
        model.addAttribute("profesion", profesion);

        return "/views/profesiones/crear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id ,RedirectAttributes attribute){

        profesionService.eliminar(id);
        attribute.addFlashAttribute("warning", "Profesión eliminada con éxito");
        return "redirect:/views/profesiones/";
    }
}
