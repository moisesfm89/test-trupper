package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.ListaCompra;
@Repository
public interface ListaCompraRepository extends CrudRepository<ListaCompra, Long>{

	public ListaCompra findByNombre(String nombre);
	public ListaCompra findByClienteIdCliente(Long idCliente);
	@Query("SELECT lc FROM ListaCompra lc JOIN lc.cliente c WHERE c.idCliente = ?1 ")
	public List<ListaCompra> findByCliente(Long idCliente);
}
