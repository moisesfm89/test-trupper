package com.example.demo.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable{
	
	private String usuario;
	private String token;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
