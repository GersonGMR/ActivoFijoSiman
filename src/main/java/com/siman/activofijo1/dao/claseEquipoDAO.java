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
import com.siman.activofijo1.model.claseEquipo;

@Repository
@Transactional
public class claseEquipoDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public claseEquipoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    public List<claseEquipo> list() {
    	String sql = "SELECT clase_equipo.id_claseequipo, clase_equipo.nombre_claseequipo, clase_equipo.flag, clase_equipo.id_tipoequipo, tipo_equipo.descripcion FROM clase_equipo INNER JOIN tipo_equipo ON tipo_equipo.id_tipoequipo = clase_equipo.id_tipoequipo";
    	
    	List<claseEquipo> listClase = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(claseEquipo.class));
    	return listClase;
    }
    
    public void saveClase(claseEquipo claseequipo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("clase_equipo").usingColumns("nombre_claseequipo", "flag", "id_tipoequipo");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(claseequipo);
         
        insertActor.execute(param); 
    }
  
    public claseEquipo getClase(int id_claseequipo) {
    	String sql = "SELECT * FROM CLASE_EQUIPO WHERE id_claseequipo = ?";
        Object[] args = {id_claseequipo};
        claseEquipo listClase = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(claseEquipo.class));
        return listClase;
    }
  
    public void updateClase(claseEquipo claseequipo) {
    	String sql = "UPDATE CLASE_EQUIPO SET nombre_claseequipo=:nombre_claseequipo, flag=:flag, id_tipoequipo=:id_tipoequipo WHERE id_claseequipo=:id_claseequipo";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(claseequipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteClase(int id_claseequipo) {
    	String sql = "DELETE FROM CLASE_EQUIPO WHERE id_claseequipo = ?";
        jdbcTemplate.update(sql, id_claseequipo);
    }
    
    //LISTA PARA LLENAR COMBOBOX
    public List<claseEquipo> getTipo() {
    	String sql = "SELECT tipo_equipo.id_tipoequipo, tipo_equipo.descripcion FROM TIPO_EQUIPO";
    	
    	List<claseEquipo> getTipo = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(claseEquipo.class));
    	return getTipo;
    }
	 

}
