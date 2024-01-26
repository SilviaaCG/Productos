package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
// Para indicar la direccion del servidor será la que iniciará esta clase
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    @GetMapping(path = "/id={id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id){
        if(usuarioService.obtenerPorId(id).isPresent()){
            return usuarioService.obtenerPorId(id);
        }else{
            return null;
        }
    }
    @GetMapping(path = "/prioridad={prioridad}")
    public ArrayList<UsuarioModel> obtenerPorPrioridad(@PathVariable("prioridad") int prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con Id " + id;
        }else{
            return "No de eliminó el usuario con Id " + id;
        }
    }

}
