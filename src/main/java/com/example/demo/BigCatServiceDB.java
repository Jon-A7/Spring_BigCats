package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class BigCatServiceDB implements BigCatService {
	private BigCatRepo repo;
	
	@Autowired
	public BigCatServiceDB(BigCatRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public BigCat createBigCat(BigCat cat) { 
		BigCat created = this.repo.save(cat); // INSERT INTO DINOSAUR...
		return created;
	}

	@Override
	public List<BigCat> getAllCats() {
		return this.repo.findAll(); // SELECT * FROM DINO...
	}

	@Override
	public BigCat getCat(Integer id) {
		Optional<BigCat> found = this.repo.findById(id); // SELECT * FROM DINO... WHERE ID=
		return found.get();
	}

	@Override
	public BigCat replaceCat(Integer id, BigCat newCat) {
		BigCat existing = this.repo.findById(id).get();
		
		existing.setWeight(newCat.getWeight());
		existing.setHeight(newCat.getHeight());
		existing.setSpecies(newCat.getSpecies());
		
		BigCat updated = this.repo.save(existing);
		
		return updated;
	}

	@Override
	public void removeCat(Integer id) {
		this.repo.deleteById(id); // DELETE FROM DINOSAUR WHERE ID=
		
	}

	@Override
	public List<BigCat> getAllCatsBySpecies(String species) {
		List<BigCat> found = this.repo.findBySpecies(species);
		return found;
	}

}
