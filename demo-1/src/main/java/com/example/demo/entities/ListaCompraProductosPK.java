package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ListaCompraProductosPK implements Serializable{
	
	private static final long serialVersionUID = 7970155022331269508L;
	private Long idLista;
	private Long idProducto;
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idLista, idProducto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCompraProductosPK other = (ListaCompraProductosPK) obj;
		return Objects.equals(idLista, other.idLista) && Objects.equals(idProducto, other.idProducto);
	}
	public Long getIdLista() {
		return idLista;
	}
	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
	

}
