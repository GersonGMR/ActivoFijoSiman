package com.siman.activofijo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASE_EQUIPO")
public class ClaseEquipoModel {
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_CLASEEQUIPO")
	private Integer claseequipoId;
	@Column(name = "NOMBRE_CLASEEQUIPO")
	private String claseequipoNombre;
	@Column(name = "FLAG")
	private String flag;
	@Column(name ="ID_TIPOEQUIPO")
	private Integer tipoequipoId;
	
	public Integer getClaseEquipoId() {
		return claseequipoId;
	}
	
	public void setClaseEquipoId(Integer claseequipoId) {
		this.claseequipoId= claseequipoId;
	}
	
	public String getClaseEquipoNombre() {
		return claseequipoNombre;
	}
	
	public void setClaseEquipoNombre(String claseequipoNombre) {
		this.claseequipoNombre = claseequipoNombre;
	}
	
	public String getflag() {
		return flag;
	}
	
	public void setflag(String flag) {
		this.flag = flag;
	}
	
	public Integer getTipoEquipoId() {
		return tipoequipoId;
	}
	
	public void setTipoEquipoId(Integer tipoequipoId) {
		this.tipoequipoId = tipoequipoId;
	}

}
