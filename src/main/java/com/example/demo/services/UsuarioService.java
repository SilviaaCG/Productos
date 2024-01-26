package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    //Implementación de el repositorio
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     *  Obtener los usuarios de la tabla usuario
     * @return
     */
    public ArrayList<UsuarioModel> obtenerUsuarios(){
       return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Guardar un usuario
     * @param usuario
     * @return
     */
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * Buscar un usuario por el ID
     * @param id
     * @return
     */
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<UsuarioModel> obtenerPorPrioridad(int prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    /**
     * Eliminaar un usuario por el Id
     * @param id
     * @return
     */
    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
