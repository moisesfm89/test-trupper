package com.example.demo.to;

import java.io.Serializable;
import java.util.List;

public class CambiarListaCompraTO implements Serializable{

	
	private static final long serialVersionUID = -7171386610225660302L;
	private String nombreNuevo;
	private List<ListaPruductoTO> lista;
	
	
	public String getNombreNuevo() {
		return nombreNuevo;
	}
	public void setNombreNuevo(String nombreNuevo) {
		this.nombreNuevo = nombreNuevo;
	}
	public List<ListaPruductoTO> getLista() {
		return lista;
	}
	public void setLista(List<ListaPruductoTO> lista) {
		this.lista = lista;
	}
	
	
}
