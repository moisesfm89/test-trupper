package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.ListaCompra;
import com.example.demo.to.CambiarListaCompraTO;
import com.example.demo.to.ComprasTO;


public interface ListaCompras {

	public void agregarListaCompras(ComprasTO ComprasTO);
	
	public void modificarListaCompras(Long idCliente, CambiarListaCompraTO cambiarListaCompraTO);
	
	public void eliminarCompra(Long id);
	
	public List<ListaCompra> buscarListaCompra(Long idCliente);
}
