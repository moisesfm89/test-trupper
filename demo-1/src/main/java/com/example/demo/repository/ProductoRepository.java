package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Producto;
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
