package com.automotor.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.automotor.controller.base.AutoBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/AutoMotor.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class AutoController extends AutoBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
