package com.example.demo.controllers;

import com.example.demo.models.ProductoModel;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    ProductoService productoService;
    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("/rebajados")
    public ArrayList<ProductoModel> obtenerProductosRebajados(){
        ArrayList<ProductoModel> listProductosCopy = new ArrayList<>();
        for(ProductoModel producto : productoService.obtenerProductos()){
            if(producto.getPrecio()>60){
                double rebaja = producto.getPrecio()-(producto.getPrecio()*0.10);
                producto.setPrecio(rebaja);
                listProductosCopy.add(producto);
            }
        }
        return listProductosCopy;
    }
    @GetMapping(path = "/get={id}")
    public Optional<ProductoModel> encontrarProductoPorId(@PathVariable("id") Long id){
        return productoService.buscarPorId(id);

    }
    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto){
        return this.productoService.guardarProducto(producto);
    }

    @DeleteMapping(path = "/delete={id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.productoService.eliminarPorId(id);
        if (ok){
            return "Se ha eliminado el producto con Id " + id;
        }else{
            return  "No se ha eliminado el producto con Id " + id;
        }
    }

}
