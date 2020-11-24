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
import com.siman.activofijo1.model.memoriaModel;
  
@Repository
@Transactional
public class memoriaDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public memoriaDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<memoriaModel> list() {
    	String sql = "SELECT MEMORIA.ID_MEMORIA, MEMORIA.memoria FROM MEMORIA";
    	
    	List<memoriaModel> listMemo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(memoriaModel.class));
    	return listMemo;
    }
  
    public void saveMemo(memoriaModel memoriamodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("memoria").usingColumns("memoria");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(memoriamodel);
         
        insertActor.execute(param); 
    }
  
    public memoriaModel getMemo(int id_memoria) {
    	String sql = "SELECT * FROM MEMORIA WHERE id_memoria = ?";
        Object[] args = {id_memoria};
        memoriaModel listMemo = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(memoriaModel.class));
        return listMemo;
    }
  
    public void updateMemo(memoriaModel memoriamodel) {
    	String sql = "UPDATE MEMORIA SET memoria=:memoria WHERE id_memoria=:id_memoria";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(memoriamodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteMemo(int id_memoria) {
    	String sql = "DELETE FROM MEMORIA WHERE id_memoria = ?";
        jdbcTemplate.update(sql, id_memoria);
    }
    

}
