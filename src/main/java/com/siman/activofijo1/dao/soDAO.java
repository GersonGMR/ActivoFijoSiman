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
import com.siman.activofijo1.model.soModel;
  
@Repository
@Transactional
public class soDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public soDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<soModel> list() {
    	String sql = "SELECT SISTEMA_OPERATIVO.id_sistemaop, SISTEMA_OPERATIVO.nombre_sistemaop FROM SISTEMA_OPERATIVO";
    	
    	List<soModel> listSO = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(soModel.class));
    	return listSO;
    }
  
    public void saveSO(soModel somodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sistema_operativo").usingColumns("nombre_sistemaop");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(somodel);
         
        insertActor.execute(param); 
    }
  
    public soModel getSO(int id_sistemaop) {
    	String sql = "SELECT * FROM SISTEMA_OPERATIVO WHERE id_sistemaop = ?";
        Object[] args = {id_sistemaop};
        soModel listSO = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(soModel.class));
        return listSO;
    }
  
    public void updateSO(soModel somodel) {
    	String sql = "UPDATE SISTEMA_OPERATIVO SET nombre_sistemaop=:nombre_sistemaop WHERE id_sistemaop=:id_sistemaop";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(somodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteSO(int id_sistemaop) {
    	String sql = "DELETE FROM SISTEMA_OPERATIVO WHERE id_sistemaop = ?";
        jdbcTemplate.update(sql, id_sistemaop);
    }
    

}
