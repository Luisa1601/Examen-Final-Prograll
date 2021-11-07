package com.example.finalcatalog.controllers;

import com.example.finalcatalog.models.entities.Departamento;
import com.example.finalcatalog.models.entities.Profesion;
import com.example.finalcatalog.services.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/views/departamentos")
public class DepartamentoController {


    final IDepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(
            IDepartamentoService departamentoService
    ){
        this.departamentoService = departamentoService;
    }

    @GetMapping("/")
    public String listar(Model model){

        List<Departamento> departamentos = departamentoService.listar();
        model.addAttribute("titulo", "Lista de departamentos");
        model.addAttribute("departamentos", departamentos);

        return  "/views/departamentos/listar";
    }

    @GetMapping("/nuevo")
    public String crear(Model model){

        Departamento departamento = new Departamento();
        model.addAttribute("titulo", "Agregar nuevo departamento");
        model.addAttribute("departamento", departamento);

        return "/views/departamentos/crear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute  Departamento departamento, RedirectAttributes attribute) {
        departamentoService.guardar(departamento);
        attribute.addFlashAttribute("success", "Departamento guardado con éxito");
        return "redirect:/views/departamentos/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){

        Departamento departamento = departamentoService.buscarPorId(id);

        model.addAttribute("titulo", "Formulario: Editar departamento");
        model.addAttribute("departamento", departamento);

        return "/views/departamentos/crear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id ,RedirectAttributes attribute){

        departamentoService.eliminar(id);
        attribute.addFlashAttribute("warning", "Departamento eliminado con éxito");
        return "redirect:/views/departamentos/";
    }
}
