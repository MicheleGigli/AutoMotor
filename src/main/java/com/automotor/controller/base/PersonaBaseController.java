package com.automotor.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.automotor.db.automotor_db.service.PersonaService;
import com.automotor.db.automotor_db.entity.Persona;

//IMPORT RELATIONS
import com.automotor.db.automotor_db.entity.Auto;

public class PersonaBaseController {
    
    @Autowired
	PersonaService personaService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/personas", method = RequestMethod.POST, headers = "Accept=application/json")
	public Persona insert(@RequestBody Persona obj) {
		Persona result = personaService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		personaService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Persona get(@PathVariable Long id) {
		Persona obj = personaService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/personas", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Persona> getList() {
		return personaService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Persona update(@RequestBody Persona obj, @PathVariable("id") Long id) {
		Persona result = personaService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
