package com.summitwt.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	int id;
	@NotBlank
	@Size(min = 3, max = 50)
	String name;
	@NotBlank
	@Size(min = 3, max = 50)
	String capital;
	@NotBlank
	@Min(value =1)
	int population;

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String name, String capital, int population) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
