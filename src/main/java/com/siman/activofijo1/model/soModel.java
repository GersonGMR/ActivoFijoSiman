package com.siman.activofijo1.model;

public class soModel {
	private int id_sistemaop;
	private String nombre_sistemaop;
	
	
	public soModel() {

	}


	public soModel(String nombre_sistemaop) {
		this.nombre_sistemaop = nombre_sistemaop;
	}


	public int getId_sistemaop() {
		return id_sistemaop;
	}


	public void setId_sistemaop(int id_sistemaop) {
		this.id_sistemaop = id_sistemaop;
	}


	public String getNombre_sistemaop() {
		return nombre_sistemaop;
	}


	public void setNombre_sistemaop(String nombre_sistemaop) {
		this.nombre_sistemaop = nombre_sistemaop;
	}


	@Override
	public String toString() {
		return "soModel [id_sistemaop=" + id_sistemaop + ", nombre_sistemaop=" + nombre_sistemaop
				+ ", getId_sistemaop()=" + getId_sistemaop() + ", getNombre_sistemaop()=" + getNombre_sistemaop()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
