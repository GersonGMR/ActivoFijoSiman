package com.siman.activofijo1.model;

import java.sql.Date;

public class activoFijo {
	
	private int id_activofijo;
	private int id_usuario;
	private String numero_activo;
	private int id_tipoequipo;
	private String descripcion;
	private int ticket;
	private int po;
	private String envio_entrada;
	private int id_proveedor;
	private String nombre_proveedor;
	private String credito_fiscal;
	private String retaceo;
	private double job_costing;
	private int id_garantia;
	private String duracion_garantia;
	private int id_claseequipo;
	private String nombre_claseequipo;
	private int id_marca;
	private String nombre_marca;
	private int id_familia;
	private String nombre_familia;
	private int id_modelo;
	private String nombre_modelo;
	private Date fecha_ingreso;
	private int id_sistemaop;
	private String nombre_sistemaop;
	private String llave_producto;
	private String serie;
	private int id_comprador;
	private String nombre_comprador;
	private int id_procesador;
	private String nombre_procesador;
	private int id_memoria;
	private String memoria;
	private int id_discoduro;
	private String espacio;
	private int teclado;
	private int mouse;
	private String comentario;
	
	
	public activoFijo() {
		
	}
	
	
	public activoFijo(int id_usuario, String numero_activo, int id_tipoequipo, String descripcion, int ticket, int po, String envio_entrada, 
				      int id_proveedor, String nombre_proveedor, String credito_fiscal, String retaceo, double job_costing, 
				      int id_garantia, String duracion_garantia, int id_claseequipo, String nombre_claseequipo, int id_marca, 
				      String nombre_marca, int id_familia, String nombre_familia, int id_modelo, String nombre_modelo, 
				      Date fecha_ingreso, int id_sistemaop, String nombre_sistemaop, String llave_producto, String serie, 
				      int id_comprador, String nombre_comprador, int id_procesador, String nombre_procesador, int id_memoria, String memoria, 
				      int id_discoduro, String espacio, int teclado, int mouse, 
					  String comentario) {
		
		this.id_usuario = id_usuario;
		this.numero_activo = numero_activo;
		this.id_tipoequipo = id_tipoequipo;
		this.descripcion = descripcion;
		this.ticket = ticket;
		this.po = po;
		this.envio_entrada = envio_entrada;
		this.id_proveedor = id_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.credito_fiscal = credito_fiscal;
		this.retaceo = retaceo;
		this.job_costing = job_costing;
		this.id_garantia = id_garantia;
		this.duracion_garantia = duracion_garantia;
		this.id_claseequipo = id_claseequipo;
		this.nombre_claseequipo = nombre_claseequipo;
		this.id_marca = id_marca;
		this.nombre_marca = nombre_marca;
		this.id_familia = id_familia;
		this.nombre_familia = nombre_familia;
		this.id_modelo = id_modelo;
		this.nombre_modelo = nombre_modelo;
		this.fecha_ingreso = fecha_ingreso;
		this.id_sistemaop = id_sistemaop;
		this.nombre_sistemaop = nombre_sistemaop;
		this.llave_producto = llave_producto;
		this.serie = serie;
		this.id_comprador = id_comprador;
		this.nombre_comprador = nombre_comprador;
		this.id_procesador = id_procesador;
		this.nombre_procesador = nombre_procesador;
		this.id_memoria = id_memoria;
		this.memoria = memoria;
		this.id_discoduro = id_discoduro;
		this.espacio = espacio;
		this.teclado = teclado;
		this.mouse = mouse;
		this.comentario = comentario;
		
	}
	
	
	public int getId_activofijo() {
		return id_activofijo;
	}

	public void setId_activofijo(int id_activofijo) {
		this.id_activofijo = id_activofijo;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNumero_activo() {
		return numero_activo;
	}

	public void setNumero_activo(String numero_activo) {
		this.numero_activo = numero_activo;
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
	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
	public int getPo() {
		return po;
	}

	public void setPo(int po) {
		this.po = po;
	}
	
	public String getEnvio_entrada() {
		return envio_entrada;
	}

	public void setEnvio_entrada(String envio_entrada) {
		this.envio_entrada = envio_entrada;
	}
	
	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	
	public String getCredito_fiscal() {
		return credito_fiscal;
	}

	public void setCredito_fiscal(String credito_fiscal) {
		this.credito_fiscal = credito_fiscal;
	}
	
	public String getRetaceo() {
		return retaceo;
	}

	public void setRetaceo(String retaceo) {
		this.retaceo = retaceo;
	}
	
	public double getJob_costing() {
		return job_costing;
	}

	public void setJob_costing(double job_costing) {
		this.job_costing = job_costing;
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
	
	public int getId_familia() {
		return id_familia;
	}

	public void setId_familia(int id_familia) {
		this.id_familia = id_familia;
	}
	
	public String getNombre_familia() {
		return nombre_familia;
	}

	public void setNombre_familia(String nombre_familia) {
		this.nombre_familia = nombre_familia;
	}
	
	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	
	public String getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
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
	
	public String getLlave_producto() {
		return llave_producto;
	}

	public void setLlave_producto(String llave_producto) {
		this.llave_producto = llave_producto;
	}
	
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public int getId_comprador() {
		return id_comprador;
	}

	public void setId_comprador(int id_comprador) {
		this.id_comprador = id_comprador;
	}
	
	public String getNombre_comprador() {
		return nombre_comprador;
	}

	public void setNombre_comprador(String nombre_comprador) {
		this.nombre_comprador = nombre_comprador;
	}
	
	public int getId_procesador() {
		return id_procesador;
	}

	public void setId_procesador(int id_procesador) {
		this.id_procesador = id_procesador;
	}
	
	public String getNombre_procesador() {
		return nombre_procesador;
	}

	public void setNombre_procesador(String nombre_procesador) {
		this.nombre_procesador = nombre_procesador;
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
	
	public int getTeclado() {
		return teclado;
	}

	public void setTeclado(int teclado) {
		this.teclado = teclado;
	}
	
	public int getMouse() {
		return mouse;
	}

	public void setMouse(int mouse) {
		this.mouse = mouse;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "activoFijo [id_activofijo=" + id_activofijo + ", id_usuario=" + id_usuario + ", numero_activo=" + numero_activo +
				", id_tipoequipo=" + id_tipoequipo + ", ticket=" + ticket + ", po=" + po + ", envio_entrada=" + envio_entrada + 
				", id_proveedor=" + id_proveedor + ", credito_fiscal=" + credito_fiscal + ", retaceo=" + retaceo + 
				", job_costing=" + job_costing + ", id_garantia=" + id_garantia + ", id_claseequipo=" + id_claseequipo + 
				", id_marca=" + id_marca + ", id_familia=" + id_familia + ", id_modelo=" + id_modelo + ", fecha_ingreso=" + fecha_ingreso +
				", id_sistemaop=" + id_sistemaop + ", llave_producto=" + llave_producto + ", serie=" + serie + ", id_comprador=" + id_comprador +
				", id_procesador=" + id_procesador + ", id_memoria=" + id_memoria + ", id_discoduro=" + id_discoduro + 
				", teclado=" + teclado + ", mouse=" + mouse + ", comentario=" + comentario + "]";
	}

}
