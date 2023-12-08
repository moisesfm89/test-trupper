package com.example.demo.to;

import java.io.Serializable;

public class ListaPruductoTO implements Serializable{

	private static final long serialVersionUID = -40911588031147574L;
	
	private Long idProducto;
	private Integer cantidad;
	
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
