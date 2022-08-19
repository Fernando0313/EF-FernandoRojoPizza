package com.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name="pizza")
@Data
@NoArgsConstructor
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPizza;
	private String nombrePizza;
	private String descripcion;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="pizza_pizerria",
		joinColumns =
			@JoinColumn(
					name="id_pizerria", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pizerria) references pizerria (id_pizerria)")),
			
		inverseJoinColumns = 
			@JoinColumn(
					name="id_pizza", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pizza) references pizza (id_pizza)"))
	)
	private List<Cliente> cliente = new ArrayList<Cliente>();
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="pizza_cliente",
		joinColumns =
			@JoinColumn(
					name="id_cliente", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references cliente (id_cliente)")),
			
		inverseJoinColumns = 
			@JoinColumn(
					name="id_pizza", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pizza) references pizza (id_pizza)"))
	)
	private List<Pizerria> pizerria = new ArrayList<Pizerria>();
	
	
	
	
	
}
