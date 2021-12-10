package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BigCatRepo extends JpaRepository<BigCat, Integer> {
	// Spring will auto-generate all of the basic CRUD functionality

		List<BigCat> findBySpecies(String species);

		List<BigCat> findByHeight(Integer height);

		List<BigCat> findByWeight(Integer weight);
}
