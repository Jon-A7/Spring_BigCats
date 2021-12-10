package com.example.demo;

import java.util.List;


public interface BigCatService {
	

	BigCat createBigCat(BigCat cat);

	List<BigCat> getAllCats();

	BigCat getCat(Integer id);

	List<BigCat>getAllCatsBySpecies(String species);

	BigCat replaceCat(Integer id, BigCat newCat);

	void removeCat(Integer id);

}
