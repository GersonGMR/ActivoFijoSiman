package com.siman.activofijo1.model;

public class modeloEquipo {
	private int id_modelo;
	private String nombre_modelo;
	private String nombre_familia;
	private int id_familia;
	
	public modeloEquipo() {

	}

	public modeloEquipo(String nombre_modelo, String nombre_familia, int id_familia) {
		this.nombre_modelo = nombre_modelo;
		this.nombre_familia = nombre_familia;
		this.id_familia = id_familia;
	}

	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}

	public String getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}

	public String getNombre_familia() {
		return nombre_familia;
	}

	public void setNombre_familia(String nombre_familia) {
		this.nombre_familia = nombre_familia;
	}

	public int getId_familia() {
		return id_familia;
	}

	public void setId_familia(int id_familia) {
		this.id_familia = id_familia;
	}

	@Override
	public String toString() {
		return "modeloEquipo [id_modelo=" + id_modelo + ", nombre_modelo=" + nombre_modelo + ", nombre_familia="
				+ nombre_familia + ", id_familia=" + id_familia + ", getId_modelo()=" + getId_modelo()
				+ ", getNombre_modelo()=" + getNombre_modelo() + ", getNombre_familia()=" + getNombre_familia()
				+ ", getId_familia()=" + getId_familia() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
