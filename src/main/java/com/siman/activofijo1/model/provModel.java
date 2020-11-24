package com.siman.activofijo1.model;

public class provModel {
	private int id_proveedor;
	private String nombre_proveedor;
	
	
	public provModel() {

	}


	public provModel(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}


	public int getId_proveedor() {
		return id_proveedor;
	}


	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}


	public String getNombre_proveedor() {
		return nombre_proveedor;
	}


	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}


	@Override
	public String toString() {
		return "provModel [id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor
				+ ", getId_proveedor()=" + getId_proveedor() + ", getNombre_proveedor()=" + getNombre_proveedor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}
