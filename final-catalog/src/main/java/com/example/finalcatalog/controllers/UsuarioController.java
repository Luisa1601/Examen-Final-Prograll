package com.example.finalcatalog.controllers;

import com.example.finalcatalog.models.entities.Departamento;
import com.example.finalcatalog.models.entities.Profesion;
import com.example.finalcatalog.models.entities.Usuario;
import com.example.finalcatalog.models.entities.UsuarioDto;
import com.example.finalcatalog.services.IDepartamentoService;
import com.example.finalcatalog.services.IProfesionService;
import com.example.finalcatalog.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {

    final IUsuarioService usuarioService;
    final IProfesionService profesionService;
    final IDepartamentoService departamentoService;

    @Autowired
    public UsuarioController(
            IUsuarioService usuarioService,
            IProfesionService profesionService,
            IDepartamentoService departamentoService
    ){
        this.usuarioService = usuarioService;
        this.profesionService = profesionService;
        this.departamentoService = departamentoService;
    }

    @GetMapping("/")
    public String listarUsuarios(Model model){

        List<UsuarioDto> usuarios = usuarioService.obtenerUsuariosDto();

        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("usuarios", usuarios);

        return  "/views/usuarios/listar";
    }

    @GetMapping("/dto")
    public String listarUsuariosDto(){

        List<UsuarioDto> usuariosDto = usuarioService.obtenerUsuariosDto();
        return  "/views/usuarios/listar";
    }

    @GetMapping("/nuevo")
    public String crearUsuario(Model model){

        Usuario usuario = new Usuario();
        List<Profesion> profesiones = profesionService.listar();
        List<Departamento> departamentos = departamentoService.listar();

        model.addAttribute("titulo", "Agregar nuevo usuario.");
        model.addAttribute("usuario", usuario);
        model.addAttribute("profesiones", profesiones);
        model.addAttribute("departamentos", departamentos);

        return "/views/usuarios/crear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario, RedirectAttributes attribute) {
        usuario.setRegistro(new Date());
        System.out.println("FECHA DE NACIMIENTO ---------- "+usuario.getNacimiento());
        usuarioService.guardar(usuario);
        attribute.addFlashAttribute("success", "Usuario guardado con éxito");
        return "redirect:/views/usuarios/";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model){

        Usuario usuario = usuarioService.buscarPorId(id);
        List<Profesion> profesiones = profesionService.listar();
        List<Departamento> departamentos = departamentoService.listar();

        model.addAttribute("titulo", "Formulario: Editar usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("profesiones", profesiones);
        model.addAttribute("departamentos", departamentos);

        return "/views/usuarios/crear";
    }

    @GetMapping("/detalle/{id}")
    public String verUsuario(@PathVariable("id") Long id, Model model){

        Usuario usuario = usuarioService.buscarPorId(id);
        model.addAttribute("usuario", usuario);

        return "/views/usuarios/detalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id ,RedirectAttributes attribute){

        usuarioService.eliminar(id);
        attribute.addFlashAttribute("warning", "Usuario eliminado con éxito");
        return "redirect:/views/usuarios/";
    }
}
