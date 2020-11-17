package com.siman.activofijo1.model;

public class familiaEquipo {
	private int id_familia;
	private String nombre_familia;
	private int flag;
	private String nombre_marca;
	private int id_marca;
	
	public familiaEquipo() {

	}

	public familiaEquipo(String nombre_familia, int flag, String nombre_marca, int id_marca) {
		this.nombre_familia = nombre_familia;
		this.flag = flag;
		this.nombre_marca = nombre_marca;
		this.id_marca = id_marca;
	}

	public int getId_familia() {
		return id_familia;
	}

	public void setId_familia(int id_familia) {
		this.id_familia = id_familia;
	}

	public String getNombre_familia() {
		return nombre_familia;
	}

	public void setNombre_familia(String nombre_familia) {
		this.nombre_familia = nombre_familia;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	@Override
	public String toString() {
		return "familiaEquipo [id_familia=" + id_familia + ", nombre_familia=" + nombre_familia + ", flag=" + flag
				+ ", nombre_marca=" + nombre_marca + ", id_marca=" + id_marca + ", getId_familia()=" + getId_familia()
				+ ", getNombre_familia()=" + getNombre_familia() + ", getFlag()=" + getFlag() + ", getNombre_marca()="
				+ getNombre_marca() + ", getId_marca()=" + getId_marca() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
