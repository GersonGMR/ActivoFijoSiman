package com.siman.activofijo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "TIPO_EQUIPO")
public class TipoEquipoModel {
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_TIPOEQUIPO")
	private Integer tipoequipoId;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "FLAG")
	private String flag;
	@Column(name = "ID_ESTADO")
	private Integer estadoId;
	 
	
	public Integer getTipoEquipoId() {
		return tipoequipoId;
	}
	
	public void setTipoEquipoId(Integer tipoequipoId) {
		this.tipoequipoId = tipoequipoId;
	}
	
	public String getdescripcion() {
		return descripcion;
	}
	
	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getflag() {
		return flag;
	}
	
	public void setflag(String flag) {
		this.flag = flag;
	}
	
	public Integer getestadoId() {
		return estadoId;
	}
	
	public void setestadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}
}
