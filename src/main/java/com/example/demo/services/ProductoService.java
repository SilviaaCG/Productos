package com.example.demo.services;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoService {
    //Implementación del repositorio
    @Autowired
    ProductoRepository productoRepository;

    /**
     * Obtener todos los productos
     * @return ArrayList de productos
     */
    public ArrayList<ProductoModel> obtenerProductos(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    /**
     * Guardar un producto
     * @param producto
     * @return
     */
    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    /**
     * Buscar producto por Id
     * @param id
     * @return
     */
    public Optional<ProductoModel>  buscarPorId(Long id){
        return productoRepository.findById(id);
    }

    /**
     * Buscar productos por nombre
     * @param nombre
     * @return
     */
    public ArrayList<ProductoModel> obtenerPorNombre(String nombre){
        return (ArrayList<ProductoModel>) productoRepository.findByNombre(nombre);
    }
    public boolean eliminarPorId(Long id){
        try{
            productoRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
