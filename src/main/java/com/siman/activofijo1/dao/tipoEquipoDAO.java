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
import com.siman.activofijo1.model.tipoEquipo;
  
@Repository
@Transactional
public class tipoEquipoDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public tipoEquipoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<tipoEquipo> list() {
    	String sql = "SELECT tipo_equipo.id_tipoequipo, tipo_equipo.descripcion, tipo_equipo.flag, estado.estado FROM TIPO_EQUIPO INNER JOIN ESTADO ON ESTADO.ID_ESTADO = TIPO_EQUIPO.ID_ESTADO";
    	
    	List<tipoEquipo> listEquipo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(tipoEquipo.class));
    	return listEquipo;
    }
  
    public void save(tipoEquipo tipoequipo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("tipo_equipo").usingColumns("descripcion", "flag", "id_estado");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tipoequipo);
         
        insertActor.execute(param); 
    }
  
    public tipoEquipo get(int id_tipoequipo) {
    	String sql = "SELECT * FROM TIPO_EQUIPO WHERE id_tipoequipo = ?";
        Object[] args = {id_tipoequipo};
        tipoEquipo listEquipo = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(tipoEquipo.class));
        return listEquipo;
    }
  
    public void update(tipoEquipo tipoequipo) {
    	String sql = "UPDATE TIPO_EQUIPO SET descripcion=:descripcion, flag=:flag, id_estado=:id_estado WHERE id_tipoequipo=:id_tipoequipo";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tipoequipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void delete(int id_tipoequipo) {
    	String sql = "DELETE FROM TIPO_EQUIPO WHERE id_tipoequipo = ?";
        jdbcTemplate.update(sql, id_tipoequipo);
    }

}
