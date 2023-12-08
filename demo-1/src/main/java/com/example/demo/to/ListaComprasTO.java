package com.example.demo.to;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaComprasTO implements Serializable{
	
    private static final long serialVersionUID = -5452415000090908887L;
	@JsonProperty("Cliente") 
	private Long cliente;
    @JsonProperty("Nombre Lista") 
	private String nombreLista;
	private List<ListaPruductoTO> lista;
		
	
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public List<ListaPruductoTO> getLista() {
		return lista;
	}
	public void setLista(List<ListaPruductoTO> lista) {
		this.lista = lista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	
	
	

}
