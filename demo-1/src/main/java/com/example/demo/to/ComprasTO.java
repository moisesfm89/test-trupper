package com.example.demo.to;

import java.io.Serializable;
import java.util.List;

public class ComprasTO implements Serializable{

	private List<ListaComprasTO> listasComprasTO;

	public List<ListaComprasTO> getListasComprasTO() {
		return listasComprasTO;
	}

	public void setListasComprasTO(List<ListaComprasTO> listasComprasTO) {
		this.listasComprasTO = listasComprasTO;
	}
	
	
}
