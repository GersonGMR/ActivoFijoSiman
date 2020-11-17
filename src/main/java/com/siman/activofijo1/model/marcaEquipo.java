package com.siman.activofijo1.model;

public class marcaEquipo {
	private int id_marca;
	private String nombre_marca;
	private int flag;
	private String nombre_claseequipo;
	private int id_claseequipo;
	
	
	
	public marcaEquipo() {

	}



	public marcaEquipo(String nombre_marca, int flag, String nombre_claseequipo, int id_claseequipo) {
		this.nombre_marca = nombre_marca;
		this.flag = flag;
		this.nombre_claseequipo = nombre_claseequipo;
		this.id_claseequipo = id_claseequipo;
	}



	public int getId_marca() {
		return id_marca;
	}



	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}



	public String getNombre_marca() {
		return nombre_marca;
	}



	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}



	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}



	public String getNombre_claseequipo() {
		return nombre_claseequipo;
	}



	public void setNombre_claseequipo(String nombre_claseequipo) {
		this.nombre_claseequipo = nombre_claseequipo;
	}



	public int getId_claseequipo() {
		return id_claseequipo;
	}



	public void setId_claseequipo(int id_claseequipo) {
		this.id_claseequipo = id_claseequipo;
	}



	@Override
	public String toString() {
		return "marcaEquipo [id_marca=" + id_marca + ", nombre_marca=" + nombre_marca + ", flag=" + flag
				+ ", nombre_claseequipo=" + nombre_claseequipo + ", id_claseequipo=" + id_claseequipo
				+ ", getId_marca()=" + getId_marca() + ", getNombre_marca()=" + getNombre_marca() + ", getFlag()="
				+ getFlag() + ", getNombre_claseequipo()=" + getNombre_claseequipo() + ", getId_claseequipo()="
				+ getId_claseequipo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
