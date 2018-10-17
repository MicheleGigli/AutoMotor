package com.automotor.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.automotor.db.automotor_db.service.AutoService;
import com.automotor.db.automotor_db.entity.Auto;

//IMPORT RELATIONS
import com.automotor.db.automotor_db.entity.Auto;

public class AutoBaseController {
    
    @Autowired
	AutoService autoService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/Auto", method = RequestMethod.POST, headers = "Accept=application/json")
	public Auto insert(@RequestBody Auto obj) {
		Auto result = autoService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Auto/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		autoService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Auto/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Auto get(@PathVariable Long id) {
		Auto obj = autoService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Auto", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Auto> getList() {
		return autoService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/Auto/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Auto update(@RequestBody Auto obj, @PathVariable("id") Long id) {
		Auto result = autoService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
