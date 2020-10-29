package com.siman.activofijo1.model;

public class tipoEquipo {
	private int id_tipoequipo;
	private String descripcion;
	private int flag;
	private String estado;
	private int id_estado;
	
	public tipoEquipo() {
		
	}

	public tipoEquipo(String descripcion, int flag, String estado, int id_estado) {
		this.descripcion = descripcion;
		this.flag = flag;
		this.estado = estado;
		this.id_estado = id_estado;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	@Override
	public String toString() {
		return "tipoEquipo [id_tipoequipo=" + id_tipoequipo + ", descripcion=" + descripcion + ", flag=" + flag
				+ ", estado=" + estado + ", id_estado=" + id_estado + "]";
	}
	
	

}
