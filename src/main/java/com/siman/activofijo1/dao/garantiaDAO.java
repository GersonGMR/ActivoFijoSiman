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
import com.siman.activofijo1.model.garantiaModel;
  
@Repository
@Transactional
public class garantiaDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public garantiaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<garantiaModel> list() {
    	String sql = "SELECT * FROM GARANTIA";
    	
    	List<garantiaModel> listGar = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(garantiaModel.class));
    	return listGar;
    }
  
    public void saveGar(garantiaModel garantiamodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("garantia").usingColumns("duracion_garantia");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(garantiamodel);
         
        insertActor.execute(param); 
    }
  
    public garantiaModel getGar(int id_garantia) {
    	String sql = "SELECT * FROM GARANTIA WHERE id_garantia = ?";
        Object[] args = {id_garantia};
        garantiaModel listGar = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(garantiaModel.class));
        return listGar;
    }
  
    public void updateGar(garantiaModel garantiamodel) {
    	String sql = "UPDATE GARANTIA SET duracion_garantia=:duracion_garantia WHERE id_garantia=:id_garantia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(garantiamodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteGar(int id_garantia) {
    	String sql = "DELETE FROM GARANTIA WHERE id_garantia = ?";
        jdbcTemplate.update(sql, id_garantia);
    }
    

}
