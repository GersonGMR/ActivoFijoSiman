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
import com.siman.activofijo1.model.compradorModel;
  
@Repository
@Transactional
public class compradorDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public compradorDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<compradorModel> list() {
    	String sql = "SELECT * FROM COMPRADOR";
    	
    	List<compradorModel> listCom = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(compradorModel.class));
    	return listCom;
    }
  
    public void saveCom(compradorModel compradormodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("comprador").usingColumns("nombre_comprador");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compradormodel);
         
        insertActor.execute(param); 
    }
  
    public compradorModel getCom(int id_comprador) {
    	String sql = "SELECT * FROM COMPRADOR WHERE id_comprador = ?";
        Object[] args = {id_comprador};
        compradorModel listCom = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(compradorModel.class));
        return listCom;
    }
  
    public void updateCom(compradorModel compradormodel) {
    	String sql = "UPDATE COMPRADOR SET nombre_comprador=:nombre_comprador WHERE id_comprador=:id_comprador";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(compradormodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteCom(int id_comprador) {
    	String sql = "DELETE FROM COMPRADOR WHERE id_comprador = ?";
        jdbcTemplate.update(sql, id_comprador);
    }
    

}
