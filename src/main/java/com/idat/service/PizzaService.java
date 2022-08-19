package com.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.model.Pizza;
import com.idat.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository repo;
	
	public void registro(Pizza p) {
		repo.save(p);
	}
	
	public List<Pizza> list(){
		return repo.findAll();
	}
	
}
