package com.siman.activofijo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA")
public class MarcaEquipoModel {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_MARCA")
	private Integer marcaId;
	@Column(name = "NOMBRE_MARCA")
	private String marcaNombre;
	@Column(name = "FLAG")
	private String flag;
	@Column(name ="ID_CLASEEQUIPO")
	private Integer claseequipoId;
	
	public Integer getMarcaId() {
		return marcaId;
	}
	
	public void setMarcaId(Integer marcaId) {
		this.marcaId= marcaId;
	}
	
	public String getMarcaNombre() {
		return marcaNombre;
	}
	
	public void setMarcaNombre(String marcaNombre) {
		this.marcaNombre = marcaNombre;
	}
	
	public String getflag() {
		return flag;
	}
	
	public void setflag(String flag) {
		this.flag = flag;
	}
	
	public Integer getClaseEquipoId() {
		return claseequipoId;
	}
	
	public void setClaseEquipoId(Integer claseequipoId) {
		this.claseequipoId = claseequipoId;
	}

}
