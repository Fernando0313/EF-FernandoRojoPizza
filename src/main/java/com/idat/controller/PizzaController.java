package com.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.model.Pizza;
import com.idat.service.PizzaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PizzaController {

	
	@Autowired
	private PizzaService serv;
	
	
	 @RequestMapping(path = "/Pizza/listar", method = RequestMethod.GET)
	    public ResponseEntity<List<Pizza>> listarPizza(){
	        return new ResponseEntity<List<Pizza>>(serv.list() , HttpStatus.CREATED);  
	    }
	 
	 
	 
	  @RequestMapping(path = "/Pizza/guardar", method = RequestMethod.POST)
	    public ResponseEntity<Void> guardar(@RequestBody Pizza pizza){
	        serv.registro(pizza);
	        return  new ResponseEntity<Void>(HttpStatus.CREATED);    
	    }
}
