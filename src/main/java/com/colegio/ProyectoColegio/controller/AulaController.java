package com.colegio.ProyectoColegio.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.service.impl.AulaServiceImpl;

@RestController
@RequestMapping("/api/aula")
public class AulaController {
	@Autowired
	private AulaServiceImpl service;
	
	//localhost:8091/api/aula (GET)
	@GetMapping() 
	public ResponseEntity<List<Aula>> getAll(){
		List<Aula> aula= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(aula);
	}
	
	//localhost:8091/api/aula/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Aula> getById(@PathVariable("id") int id) {
		Aula aula = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(aula);
	}
	
	//localhost:8091/api/aula (POST)
	@PostMapping 
	public ResponseEntity<Aula> create(@RequestBody Aula aula) {
		Aula aulaDb=service.create(aula);
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaDb);
	}
	
	//localhost:8091/api/aula/1 (PUT)
	@PutMapping
	public ResponseEntity<Aula> update(@RequestBody Aula aula) {
		Aula aulaDb=service.update(aula);
		return ResponseEntity.status(HttpStatus.OK).body(aulaDb);
	}
	
	//localhost:8091/api/aula/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
