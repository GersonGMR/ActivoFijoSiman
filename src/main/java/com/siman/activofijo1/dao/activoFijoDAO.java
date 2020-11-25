package com.siman.activofijo1.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.siman.activofijo1.model.activoFijo;
import com.siman.activofijo1.model.tipoEquipo;

@Repository
@Transactional
public class activoFijoDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public activoFijoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<activoFijo> List() {
		String sql = "SELECT activo.id_activofijo, activo.id_usuario, activo.numero_activo, activo.id_tipoequipo, activo.Ticket, activo.po, activo.envio_entrada,"
				+ "       activo.id_proveedor, activo.credito_fiscal, activo.retaceo, activo.job_costing, activo.id_garantia, activo.id_claseequipo,"
				+ "       activo.id_marca, activo.id_familia, activo.id_modelo, activo.fecha_ingreso, activo.id_sistemaop, activo.llave_producto, activo.serie,"
				+ "       activo.id_comprador, activo.id_procesador, activo.id_memoria, activo.id_discoduro, activo.teclado, activo.mouse, activo.comentario"
				+ "FROM ACTIVO_FIJO activo";
		
		List<activoFijo> listActivo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
		return listActivo;
	}
	
	public void saveActivo(activoFijo activofijo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("activo_fijo").usingColumns("id_usuario", "numero_activo", "id_tipoequipo", "ticket", "po", "envio_entrada", "id_proveedor", "credito_fiscal", "retaceo", "job_costing", "id_garantia", "id_claseequipo", "id_marca", "id_familia", "id_modelo", "fecha_ingreso", "id_sistemaop", "llave_producto", "serie", "id_comprador", "id_procesador", "id_memoria", "id_discoduro", "teclado", "mouse", "comentario");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(activofijo);
         
        insertActor.execute(param); 
    }
	
	public List<activoFijo> getTipoEquipo() {
    	String sql = "SELECT tipo_equipo.id_tipoequipo, tipo_equipo.descripcion FROM TIPO_EQUIPO";
    	
    	List<activoFijo> getTipoEquipo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getTipoEquipo;
    }
	
	/*public List<activoFijo> getClaseEquipo(int id_tipoequipo) {
    	String sql = "SELECT clase_equipo.id_claseequipo, clase_equipo.nombre_claseequipo FROM CLASE_EQUIPO WHERE id_tipoequipo = ?";
    	Object[] args = {id_tipoequipo};
    	
    	List<activoFijo> getClaseEquipo = jdbcTemplate.query(sql, args,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getClaseEquipo;
    }*/
	
	public List<activoFijo> getProveedor() {
    	String sql = "SELECT proveedor.id_proveedor, proveedor.nombre_proveedor FROM PROVEEDOR";
    	
    	List<activoFijo> getProveedor = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getProveedor;
    }
	
	public List<activoFijo> getGarantia() {
    	String sql = "SELECT garantia.id_garantia, garantia.duracion_garantia FROM GARANTIA";
    	
    	List<activoFijo> getGarantia = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getGarantia;
    }
	
	public List<activoFijo> getClaseEquipo() {
    	String sql = "SELECT clase_equipo.id_claseequipo, clase_equipo.nombre_claseequipo FROM CLASE_EQUIPO";
    	
    	List<activoFijo> getClaseEquipo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getClaseEquipo;
    }
	
	public List<activoFijo> getMarca() {
    	String sql = "SELECT marca.id_marca, marca.nombre_marca FROM MARCA";
    	
    	List<activoFijo> getMarca = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getMarca;
    }
	
	public List<activoFijo> getFamilia() {
    	String sql = "SELECT familia.id_familia, familia.nombre_familia FROM FAMILIA";
    	
    	List<activoFijo> getFamilia = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getFamilia;
    }
	
	public List<activoFijo> getModelo() {
    	String sql = "SELECT modelo.id_modelo, modelo.nombre_modelo FROM MODELO";
    	
    	List<activoFijo> getModelo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getModelo;
    }
	
	public List<activoFijo> getSistemaOp() {
    	String sql = "SELECT sistema_operativo.id_sistemaop, sistema_operativo.nombre_sistemaop FROM SISTEMA_OPERATIVO";
    	
    	List<activoFijo> getSistemaOp = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getSistemaOp;
    }
	
	public List<activoFijo> getComprador() {
    	String sql = "SELECT comprador.id_comprador, comprador.nombre_comprador FROM COMPRADOR";
    	
    	List<activoFijo> getComprador = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getComprador;
    }
	
	public List<activoFijo> getProcesador() {
    	String sql = "SELECT procesador.id_procesador, procesador.nombre_procesador FROM PROCESADOR";
    	
    	List<activoFijo> getProcesador = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getProcesador;
    }
	
	public List<activoFijo> getMemoria() {
    	String sql = "SELECT memoria.id_memoria, memoria.memoria FROM MEMORIA";
    	
    	List<activoFijo> getMemoria = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getMemoria;
    }
	
	public List<activoFijo> getDiscoDuro() {
    	String sql = "SELECT disco_duro.id_discoduro, disco_duro.espacio FROM DISCO_DURO";
    	
    	List<activoFijo> getDiscoDuro = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(activoFijo.class));
        return getDiscoDuro;
    }
	
	

}
