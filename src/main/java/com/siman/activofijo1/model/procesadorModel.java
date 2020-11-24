package com.siman.activofijo1.model;

public class procesadorModel {
	private int id_procesador;
	private String nombre_procesador;
	
	
	public procesadorModel() {

	}


	public procesadorModel(String nombre_procesador) {
		this.nombre_procesador = nombre_procesador;
	}


	public int getId_procesador() {
		return id_procesador;
	}


	public void setId_procesador(int id_procesador) {
		this.id_procesador = id_procesador;
	}


	public String getNombre_procesador() {
		return nombre_procesador;
	}


	public void setNombre_procesador(String nombre_procesador) {
		this.nombre_procesador = nombre_procesador;
	}


	@Override
	public String toString() {
		return "procesadorModel [id_procesador=" + id_procesador + ", nombre_procesador=" + nombre_procesador
				+ ", getId_procesador()=" + getId_procesador() + ", getNombre_procesador()=" + getNombre_procesador()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
