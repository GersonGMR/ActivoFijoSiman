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
import com.siman.activofijo1.model.procesadorModel;
  
@Repository
@Transactional
public class procesadorDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public procesadorDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<procesadorModel> list() {
    	String sql = "SELECT PROCESADOR.id_procesador, PROCESADOR.nombre_procesador FROM PROCESADOR";
    	
    	List<procesadorModel> listPro = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(procesadorModel.class));
    	return listPro;
    }
  
    public void savePro(procesadorModel procesadormodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("procesador").usingColumns("nombre_procesador");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(procesadormodel);
         
        insertActor.execute(param); 
    }
  
    public procesadorModel getPro(int id_procesador) {
    	String sql = "SELECT * FROM PROCESADOR WHERE id_procesador = ?";
        Object[] args = {id_procesador};
        procesadorModel listPro = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(procesadorModel.class));
        return listPro;
    }
  
    public void updatePro(procesadorModel procesadormodel) {
    	String sql = "UPDATE PROCESADOR SET nombre_procesador=:nombre_procesador WHERE id_procesador=:id_procesador";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(procesadormodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deletePro(int id_procesador) {
    	String sql = "DELETE FROM PROCESADOR WHERE id_procesador = ?";
        jdbcTemplate.update(sql, id_procesador);
    }
    

}
