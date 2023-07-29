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

import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.service.impl.DocenteServiceImpl;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	@Autowired
	private DocenteServiceImpl service;
	
	//localhost:8091/api/categorias (GET)
	@GetMapping() 
	public ResponseEntity<List<Docente>> getAll(){
		List<Docente> docente= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(docente);
	}
	
	//localhost:8091/api/categorias/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Docente> getById(@PathVariable("id") int id) {
		Docente docente = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(docente);
	}
	
	//localhost:8091/api/categorias (POST)
	@PostMapping 
	public ResponseEntity<Docente> create(@RequestBody Docente docente) {
		Docente docenteDb=service.create(docente);
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteDb);
	}
	
	//localhost:8091/api/categorias/1 (PUT)
	@PutMapping
	public ResponseEntity<Docente> update(@RequestBody Docente docente) {
		Docente docenteDb=service.update(docente);
		return ResponseEntity.status(HttpStatus.OK).body(docenteDb);
	}
	
	//localhost:8091/api/categorias/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
