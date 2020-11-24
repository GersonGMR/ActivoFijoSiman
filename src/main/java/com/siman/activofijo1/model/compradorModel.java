package com.siman.activofijo1.model;

public class compradorModel {
	private int id_comprador;
	private String nombre_comprador;
	
	
	public compradorModel() {

	}


	public compradorModel(String nombre_comprador) {
		this.nombre_comprador = nombre_comprador;
	}


	public int getId_comprador() {
		return id_comprador;
	}


	public void setId_comprador(int id_comprador) {
		this.id_comprador = id_comprador;
	}


	public String getNombre_comprador() {
		return nombre_comprador;
	}


	public void setNombre_comprador(String nombre_comprador) {
		this.nombre_comprador = nombre_comprador;
	}


	@Override
	public String toString() {
		return "compradorModel [id_comprador=" + id_comprador + ", nombre_comprador=" + nombre_comprador
				+ ", getId_comprador()=" + getId_comprador() + ", getNombre_comprador()=" + getNombre_comprador()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
 
}
