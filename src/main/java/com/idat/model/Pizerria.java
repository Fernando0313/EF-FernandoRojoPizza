package com.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="pizerria")
@Table
@Data
@NoArgsConstructor
public class Pizerria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPizerria;
	private String direccion;
	private String sede;
	

	@ManyToMany(mappedBy = "pizerria", cascade = {CascadeType.PERSIST,CascadeType.MERGE}) 
	private List<Pizza> pizza = new ArrayList<Pizza>();
	
	
	
	
}
