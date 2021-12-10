package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // flags class as a table to Spring Data
public class BigCat {
	
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;

	@Column(nullable = false)
	private String species;

	@Column(unique = true)
	private Integer weight;
	private Integer height;
	
	public BigCat() {
		super();
		
	}
	
	public BigCat(String species, Integer weight, Integer height) {
		super();
		this.species = species;
		this.weight = weight;
		this.height = height;
	}
	
	public BigCat(Integer id, String species, Integer weight, Integer height) {
		super();
		this.id = id;
		this.species = species;
		this.weight = weight;
		this.height = height;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
	@Override
	public String toString() {
		return "BigCat [species=" + species + ", weight=" + weight + ", height=" + height + "]";
	}
	
	
	
}
