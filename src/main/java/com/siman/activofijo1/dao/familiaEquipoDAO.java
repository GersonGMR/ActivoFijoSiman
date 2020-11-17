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
import com.siman.activofijo1.model.familiaEquipo;
  
@Repository
@Transactional
public class familiaEquipoDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public familiaEquipoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<familiaEquipo> list() {
    	String sql = "SELECT FAMILIA.id_familia, FAMILIA.nombre_familia, FAMILIA.flag, MARCA.nombre_marca FROM FAMILIA INNER JOIN MARCA ON marca.id_marca = familia.id_marca";
    	
    	List<familiaEquipo> listFamilia = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(familiaEquipo.class));
    	return listFamilia;
    }
  
    public void saveFamilia(familiaEquipo familiaequipo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("familia").usingColumns("nombre_familia", "flag", "id_marca");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(familiaequipo);
         
        insertActor.execute(param); 
    }
  
    public familiaEquipo getFamilia(int id_familia) {
    	String sql = "SELECT * FROM FAMILIA WHERE id_familia = ?";
        Object[] args = {id_familia};
        familiaEquipo listFamilia = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(familiaEquipo.class));
        return listFamilia;
    }
  
    public void updateFamilia(familiaEquipo familiaequipo) {
    	String sql = "UPDATE FAMILIA SET nombre_familia=:nombre_familia, flag=:flag, id_marca=:id_marca WHERE id_familia=:id_familia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(familiaequipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteFamilia(int id_familia) {
    	String sql = "DELETE FROM FAMILIA WHERE id_familia = ?";
        jdbcTemplate.update(sql, id_familia);
    }
    
    //LISTA PARA LLENAR COMBOBOX
    public List<familiaEquipo> getFamarca() {
    	String sql = "SELECT marca.id_marca, marca.nombre_marca FROM marca";
    	
    	List<familiaEquipo> getFamarca = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(familiaEquipo.class));
    	return getFamarca;
    }

}
