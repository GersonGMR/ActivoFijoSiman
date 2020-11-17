package com.siman.activofijo1.model;

public class claseEquipo {
	private int id_claseequipo;
	private String nombre_claseequipo;
	private int flag;
	private int id_tipoequipo;
	private String descripcion;
	
	
	
	public claseEquipo() {

	}

	public claseEquipo(String nombre_claseequipo, int flag, int id_tipoequipo, String descripcion) {
		this.nombre_claseequipo = nombre_claseequipo;
		this.flag = flag;
		this.id_tipoequipo = id_tipoequipo;
		this.descripcion = descripcion;
	}

	public int getId_claseequipo() {
		return id_claseequipo;
	}

	public void setId_claseequipo(int id_claseequipo) {
		this.id_claseequipo = id_claseequipo;
	}

	public String getNombre_claseequipo() {
		return nombre_claseequipo;
	}

	public void setNombre_claseequipo(String nombre_claseequipo) {
		this.nombre_claseequipo = nombre_claseequipo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getId_tipoequipo() {
		return id_tipoequipo;
	}

	public void setId_tipoequipo(int id_tipoequipo) {
		this.id_tipoequipo = id_tipoequipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "claseEquipo [id_claseequipo=" + id_claseequipo + ", nombre_claseequipo=" + nombre_claseequipo
				+ ", flag=" + flag + ", id_tipoequipo=" + id_tipoequipo + ", descripcion=" + descripcion + "]";
	}
	
	

}
