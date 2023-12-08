package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ListaCompra;
import com.example.demo.service.ListaCompras;
import com.example.demo.to.CambiarListaCompraTO;
import com.example.demo.to.ComprasTO;

@RestController
@RequestMapping (value = "lista-compras")
public class RegistroProductosContrller {
	
	@Autowired
	private ListaCompras listaComprasService;
	
	@PostMapping(value = "compra")
	public void registroProductos (@RequestBody ComprasTO comprasTO) {
		this.listaComprasService.agregarListaCompras(comprasTO);
	}
	
	@PutMapping(value = "modificar-compra/{idCliente}")
	public void modificarCompra(@PathVariable Long idCliente, @RequestBody CambiarListaCompraTO cambiarListaCompraTO) {
		this.listaComprasService.modificarListaCompras(idCliente, cambiarListaCompraTO);
	}
	
	@GetMapping(value = "buscar-compras-id-cliente/{idCliente}")
	public List<ListaCompra> obtenerCompras(@PathVariable Long idCliente) {
		return this.listaComprasService.buscarListaCompra(idCliente);
	}
	@DeleteMapping(value = "borrar-compra/{id}")
	public void borrarCompra(@PathVariable Long id) {
		this.listaComprasService.eliminarCompra(id);
	}
	
	
	

}
