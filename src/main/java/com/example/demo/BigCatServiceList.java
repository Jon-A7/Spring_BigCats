package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BigCatServiceList implements BigCatService {
	
	private List<BigCat> cats = new ArrayList<>();

	@Override
	public BigCat createBigCat(BigCat cat) {
		this.cats.add(cat);
		BigCat created = this.cats.get(this.cats.size() - 1);
		return created;
	}

	@Override
	public List<BigCat> getAllCats() {
		// TODO Auto-generated method stub
		return this.cats;
	}

	@Override
	public BigCat getCat(Integer id) {
		return this.cats.get(id);
	}

	@Override
	public BigCat replaceCat(Integer id, BigCat newCat) {
		BigCat found = this.cats.set(id, newCat);
		return found;
	}

	@Override
	public void removeCat(Integer id) {
		this.cats.remove(id.intValue());
		
	}

	@Override
	public List<BigCat> getAllCatsBySpecies(String species) {
		// TODO Auto-generated method stub
		return null;
	}

}
