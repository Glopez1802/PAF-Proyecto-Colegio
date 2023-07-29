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

import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.service.impl.HorarioServiceImpl;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {
	@Autowired
	private HorarioServiceImpl service;
	
	//localhost:8091/api/aula (GET)
	@GetMapping() 
	public ResponseEntity<List<Horario>> getAll(){
		List<Horario> horario= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(horario);
	}
	
	//localhost:8091/api/aula/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Horario> getById(@PathVariable("id") int id) {
		Horario horario = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(horario);
	}
	
	//localhost:8091/api/aula (POST)
	@PostMapping 
	public ResponseEntity<Horario> create(@RequestBody Horario horario) {
		Horario horarioDb=service.create(horario);
		return ResponseEntity.status(HttpStatus.CREATED).body(horarioDb);
	}
	
	//localhost:8091/api/aula/1 (PUT)
	@PutMapping
	public ResponseEntity<Horario> update(@RequestBody Horario horario) {
		Horario horarioDb=service.update(horario);
		return ResponseEntity.status(HttpStatus.OK).body(horarioDb);
	}
	
	//localhost:8091/api/aula/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
