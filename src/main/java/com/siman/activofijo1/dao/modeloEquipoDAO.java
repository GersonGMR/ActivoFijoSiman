package com.siman.activofijo1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.siman.activofijo1.model.modeloEquipo;
  
@Repository
@Transactional
public class modeloEquipoDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public modeloEquipoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<modeloEquipo> list() {
    	String sql = "SELECT MODELO.ID_MODELO, MODELO.nombre_modelo,FAMILIA.nombre_familia FROM MODELO INNER JOIN FAMILIA ON familia.id_familia = modelo.id_familia";
    	
    	List<modeloEquipo> listModelo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(modeloEquipo.class));
    	return listModelo;
    }
  
    public void saveModelo(modeloEquipo modeloequipo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("modelo").usingColumns("nombre_modelo", "id_familia");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modeloequipo);
         
        insertActor.execute(param); 
    }
  
    public modeloEquipo getModelo(int id_modelo) {
    	String sql = "SELECT * FROM MODELO WHERE ID_MODELO = ?";
        Object[] args = {id_modelo};
        modeloEquipo listModelo = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(modeloEquipo.class));
        return listModelo;
    }
  
    public void updateModelo(modeloEquipo modeloequipo) {
    	String sql = "UPDATE MODELO SET nombre_modelo=:nombre_modelo, id_familia=:id_familia WHERE id_modelo=:id_modelo";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modeloequipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteModelo(int id_modelo) {
    	String sql = "DELETE FROM MODELO WHERE ID_MODELO = ?";
        jdbcTemplate.update(sql, id_modelo);
    }
    
    //LISTA PARA LLENAR COMBOBOX
    public List<modeloEquipo> getMofam() {
    	String sql = "SELECT familia.id_familia, familia.nombre_familia FROM familia";
    	
    	List<modeloEquipo> getMofam = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(modeloEquipo.class));
    	return getMofam;
    }

}
