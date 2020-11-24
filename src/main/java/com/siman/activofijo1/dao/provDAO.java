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
import com.siman.activofijo1.model.provModel;
  
@Repository
@Transactional
public class provDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public provDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<provModel> list() {
    	String sql = "SELECT * FROM PROVEEDOR";
    	
    	List<provModel> listProv = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(provModel.class));
    	return listProv;
    }
  
    public void saveProv(provModel provmodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("proveedor").usingColumns("nombre_proveedor");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(provmodel);
         
        insertActor.execute(param); 
    }
  
    public provModel getProv(int id_proveedor) {
    	String sql = "SELECT * FROM PROVEEDOR WHERE id_proveedor = ?";
        Object[] args = {id_proveedor};
        provModel listProv = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(provModel.class));
        return listProv;
    }
  
    public void updateProv(provModel provmodel) {
    	String sql = "UPDATE PROVEEDOR SET nombre_proveedor=:nombre_proveedor WHERE id_proveedor=:id_proveedor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(provmodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteProv(int id_proveedor) {
    	String sql = "DELETE FROM PROVEEDOR WHERE id_proveedor = ?";
        jdbcTemplate.update(sql, id_proveedor);
    }
    

}
