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

import com.automotor.db.automotor_db.entity.Auto;
import com.automotor.db.automotor_db.service.AutoService;

//IMPORT RELATIONS
import com.automotor.db.automotor_db.entity.Auto;

@Service
public class AutoBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Auto insert(Auto obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `auto`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `auto` (`_id`, `cc`,`colore`,`proprietario`,`tipo`) VALUES (:id,:cc,:colore,:proprietario,:tipo)";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("cc", obj.getCc())
			.addValue("colore", obj.getColore())
			.addValue("proprietario", obj.getProprietario())
			.addValue("tipo", obj.getTipo());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Auto` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Auto get(Long id) {
	    
		String sql = "select * from `Auto` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Auto) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Auto.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Auto> getList() {
	    
		String sql = "select * from `Auto`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Auto.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Auto update(Auto obj, Long id) {

		String sql = "UPDATE `Auto` SET `cc` = :cc,`colore` = :colore,`proprietario` = :proprietario,`tipo` = :tipo  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("cc", obj.getCc())
			.addValue("colore", obj.getColore())
			.addValue("proprietario", obj.getProprietario())
			.addValue("tipo", obj.getTipo());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in AutoService.java
     */
    

}
