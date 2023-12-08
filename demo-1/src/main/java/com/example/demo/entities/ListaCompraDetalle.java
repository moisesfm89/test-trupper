package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="Lista_compra_detalle")
public class ListaCompraDetalle implements Serializable{
	
	private static final long serialVersionUID = -2752930462210735412L;

	@EmbeddedId
	private ListaCompraProductosPK listaCompraProductosPK;
	
	private Integer cantidad;

	public ListaCompraProductosPK getListaCompraProductosPK() {
		return listaCompraProductosPK;
	}

	public void setListaCompraProductosPK(ListaCompraProductosPK listaCompraProductosPK) {
		this.listaCompraProductosPK = listaCompraProductosPK;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
