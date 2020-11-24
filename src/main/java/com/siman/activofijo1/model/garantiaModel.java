package com.siman.activofijo1.model;

public class garantiaModel {
	private int id_garantia;
	private String duracion_garantia;
	
	
	public garantiaModel() {

	}


	public garantiaModel(String duracion_garantia) {
		this.duracion_garantia = duracion_garantia;
	}


	public int getId_garantia() {
		return id_garantia;
	}


	public void setId_garantia(int id_garantia) {
		this.id_garantia = id_garantia;
	}


	public String getDuracion_garantia() {
		return duracion_garantia;
	}


	public void setDuracion_garantia(String duracion_garantia) {
		this.duracion_garantia = duracion_garantia;
	}


	@Override
	public String toString() {
		return "garantiaModel [id_garantia=" + id_garantia + ", duracion_garantia=" + duracion_garantia
				+ ", getId_garantia()=" + getId_garantia() + ", getDuracion_garantia()=" + getDuracion_garantia()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
    
}
