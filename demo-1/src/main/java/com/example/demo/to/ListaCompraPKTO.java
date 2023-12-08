package com.example.demo.to;

import java.io.Serializable;

public class ListaCompraPKTO implements Serializable{
	
	private static final long serialVersionUID = 6384965816603260866L;
	private String nombreLista;
	private Long idProducto;
	private Integer cantidad;
	
	
	public String getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
		

}
