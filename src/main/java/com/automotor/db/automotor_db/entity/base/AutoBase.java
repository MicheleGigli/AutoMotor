package com.automotor.db.automotor_db.entity.base;

/**
 * 
 * 
  _____                      _              _ _ _     _   _     _        __ _ _      
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |     
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___ 
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|
 
                                                                                   
 * DO NOT EDIT THIS FILE!! 
 *
 *  FOR CUSTOMIZE AutoBase PLEASE EDIT ../Auto.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Auto object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;


import org.springframework.jdbc.core.RowMapper;
import com.automotor.db.automotor_db.entity.Auto;

public class AutoBase implements RowMapper<Auto>{
	
	private Long _id;
	
	// Attributes
    private String cc;
    private String colore;
    private Integer proprietario;
    private String tipo;
	
	
	
	@Override
	public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Auto obj = new Auto();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setCc(rs.getString("cc"));
			obj.setColore(rs.getString("colore"));
			obj.setProprietario(rs.getInt("proprietario"));
			obj.setTipo(rs.getString("tipo"));
			
        	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}
	
	public String getCc() {
		return cc;
	}


	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}
	public Integer getProprietario() {
		return proprietario;
	}


	public void setProprietario(Integer proprietario) {
		this.proprietario = proprietario;
	}
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
    
    
    
    
}