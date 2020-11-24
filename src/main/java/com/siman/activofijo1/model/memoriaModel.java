package com.siman.activofijo1.model;

public class memoriaModel {
	private int id_memoria;
	private String memoria;
	
	
	public memoriaModel() {

	}


	public memoriaModel(String memoria) {
		this.memoria = memoria;
	}


	public int getId_memoria() {
		return id_memoria;
	}


	public void setId_memoria(int id_memoria) {
		this.id_memoria = id_memoria;
	}


	public String getMemoria() {
		return memoria;
	}


	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}


	@Override
	public String toString() {
		return "memoriaModel [id_memoria=" + id_memoria + ", memoria=" + memoria + ", getId_memoria()="
				+ getId_memoria() + ", getMemoria()=" + getMemoria() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

	
}
