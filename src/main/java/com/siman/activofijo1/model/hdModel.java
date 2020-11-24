package com.siman.activofijo1.model;

public class hdModel {
	private int id_discoduro;
	private String espacio;
	
	
	public hdModel() {

	}


	public hdModel(String espacio) {
		this.espacio = espacio;
	}


	public int getId_discoduro() {
		return id_discoduro;
	}


	public void setId_discoduro(int id_discoduro) {
		this.id_discoduro = id_discoduro;
	}


	public String getEspacio() {
		return espacio;
	}


	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}


	@Override
	public String toString() {
		return "hdModel [id_discoduro=" + id_discoduro + ", espacio=" + espacio + ", getId_discoduro()="
				+ getId_discoduro() + ", getEspacio()=" + getEspacio() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

	
}
