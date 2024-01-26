package com.example.demo.repositories;

import com.example.demo.models.ProductoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel,Long> {
    public abstract ArrayList<ProductoModel> findByNombre(String nombre);
}
