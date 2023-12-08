package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ListaCompraDetalle;
import com.example.demo.entities.ListaCompraProductosPK;
@Repository
public interface ListaCompraDetalleRepository extends CrudRepository<ListaCompraDetalle, ListaCompraProductosPK>{

}
