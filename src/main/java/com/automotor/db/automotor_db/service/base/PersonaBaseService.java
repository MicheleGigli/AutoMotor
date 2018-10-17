package com.automotor.db.automotor_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.automotor.db.automotor_db.entity.Persona;
import com.automotor.db.automotor_db.service.PersonaService;

//IMPORT RELATIONS
import com.automotor.db.automotor_db.entity.Auto;

@Service
public class PersonaBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Persona insert(Persona obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `persona`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `persona` (`_id`, `cognome`,`eta`,`mail`,`nome`,`FK_PEROSNA_AUTO`) VALUES (:id,:cognome,:eta,:mail,:nome, :FK_PEROSNA_AUTO )";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("cognome", obj.getCognome())
			.addValue("eta", obj.getEta())
			.addValue("mail", obj.getMail())
			.addValue("nome", obj.getNome())
			.addValue("FK_PEROSNA_AUTO", obj.getFK_PEROSNA_AUTO());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Persona` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Persona get(Long id) {
	    
		String sql = "select * from `Persona` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Persona) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Persona.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Persona> getList() {
	    
		String sql = "select * from `Persona`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Persona.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Persona update(Persona obj, Long id) {

		String sql = "UPDATE `Persona` SET `cognome` = :cognome,`eta` = :eta,`mail` = :mail,`nome` = :nome , `FK_PEROSNA_AUTO` = :FK_PEROSNA_AUTO  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("cognome", obj.getCognome())
			.addValue("eta", obj.getEta())
			.addValue("mail", obj.getMail())
			.addValue("nome", obj.getNome())
			.addValue("FK_PEROSNA_AUTO", obj.getFK_PEROSNA_AUTO());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in PersonaService.java
     */
    

}
