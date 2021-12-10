package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BigCatController {
	
	private BigCatService service;

	@Autowired // tells Spring to fetch the DinoService from the context
				// Dependency Injection
	public BigCatController(BigCatService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/helloWorld") // endpoint
	public String hello() {
		return "Hello, World!";
}
	
	@PostMapping("/create")
	public ResponseEntity<BigCat> createBigCat(@RequestBody BigCat cat) {
		BigCat created = this.service.createBigCat(cat);
		ResponseEntity<BigCat> response = new ResponseEntity<BigCat>(created, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BigCat>> getAllCats(){
		return ResponseEntity.ok(this.service.getAllCats());
	}
	
	@GetMapping("/get/{id}")
	public BigCat getCat(@PathVariable Integer id) {
		System.out.println("ID: " + id); 
		return this.service.getCat(id);
		
	}
	
	@GetMapping("/getBySpecies/{species}")
	public ResponseEntity<List<BigCat>> getDinoByType(@PathVariable String species) {
		List<BigCat> found = this.service.getAllCatsBySpecies(species);
		return ResponseEntity.ok(found);
	}
	
	@PutMapping("/replace/{id}")
	public ResponseEntity<BigCat> replaceCat(@PathVariable Integer id, @RequestBody BigCat newCat) {
		System.out.println("ID: "+id);
		System.out.println("Cat: "+newCat);
		BigCat body = this.service.replaceCat(id, newCat);
		
		ResponseEntity<BigCat> response = new ResponseEntity<BigCat>(body, HttpStatus.ACCEPTED);
		return response;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeCat(@PathVariable Integer id) {
		this.service.removeCat(id);
		System.out.println("ID: "+id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
