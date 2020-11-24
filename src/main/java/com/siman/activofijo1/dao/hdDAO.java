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
import com.siman.activofijo1.model.hdModel;
  
@Repository
@Transactional
public class hdDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public hdDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<hdModel> list() {
    	String sql = "SELECT * FROM DISCO_DURO";
    	
    	List<hdModel> listHD = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(hdModel.class));
    	return listHD;
    }
  
    public void saveHD(hdModel hdmodel) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("disco_duro").usingColumns("espacio");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(hdmodel);
         
        insertActor.execute(param); 
    }
  
    public hdModel getHD(int id_discoduro) {
    	String sql = "SELECT * FROM DISCO_DURO WHERE id_discoduro = ?";
        Object[] args = {id_discoduro};
        hdModel listHD = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(hdModel.class));
        return listHD;
    }
  
    public void updateHD(hdModel hdmodel) {
    	String sql = "UPDATE DISCO_DURO SET espacio=:espacio WHERE id_discoduro=:id_discoduro";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(hdmodel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteHD(int id_discoduro) {
    	String sql = "DELETE FROM DISCO_DURO WHERE id_discoduro = ?";
        jdbcTemplate.update(sql, id_discoduro);
    }
    

}
