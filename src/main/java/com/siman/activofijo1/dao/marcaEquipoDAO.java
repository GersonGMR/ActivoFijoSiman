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

import com.siman.activofijo1.model.marcaEquipo;
  
@Repository
@Transactional
public class marcaEquipoDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public marcaEquipoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<marcaEquipo> list() {
    	String sql = "SELECT MARCA.ID_MARCA, MARCA.nombre_marca, MARCA.flag, CLASE_EQUIPO.nombre_claseequipo FROM MARCA INNER JOIN CLASE_EQUIPO ON CLASE_EQUIPO.ID_CLASEEQUIPO = marca.id_claseequipo";
    	
    	List<marcaEquipo> listMarca = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(marcaEquipo.class));
    	return listMarca;
    }
  
    public void saveMarca(marcaEquipo marcaequipo) {
    	SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("marca").usingColumns("nombre_marca", "flag", "id_claseequipo");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marcaequipo);
         
        insertActor.execute(param); 
    }
  
    public marcaEquipo getMarca(int id_marca) {
    	String sql = "SELECT * FROM MARCA WHERE id_marca = ?";
        Object[] args = {id_marca};
        marcaEquipo listMarca = jdbcTemplate.queryForObject(sql, args,
                        BeanPropertyRowMapper.newInstance(marcaEquipo.class));
        return listMarca;
    }
  
    public void updateMarca(marcaEquipo marcaequipo) {
    	String sql = "UPDATE MARCA SET nombre_marca=:nombre_marca, flag=:flag, id_claseequipo=:id_claseequipo WHERE id_marca=:id_marca";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marcaequipo);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param); 
    }
  
    public void deleteMarca(int id_marca) {
    	String sql = "DELETE FROM MARCA WHERE id_marca = ?";
        jdbcTemplate.update(sql, id_marca);
    }
    
    //LISTA PARA LLENAR COMBOBOX
    public List<marcaEquipo> getClasemarca() {
    	String sql = "SELECT clase_equipo.id_claseequipo, clase_equipo.nombre_claseequipo FROM CLASE_EQUIPO";
    	
    	List<marcaEquipo> getClasemarca = jdbcTemplate.query(sql,
    			BeanPropertyRowMapper.newInstance(marcaEquipo.class));
    	return getClasemarca;
    }

}
