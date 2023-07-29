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

import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Apoderado;
import com.colegio.ProyectoColegio.service.impl.AlumnoServiceImpl;
import com.colegio.ProyectoColegio.service.impl.ApoderadoServiceImpl;

@RestController
@RequestMapping("/api/apoderado")

public class ApoderadoController {

	@Autowired
	private ApoderadoServiceImpl service;
	
	@Autowired
	private AlumnoServiceImpl serviceAlumno;
	
	
	@GetMapping()
	public ResponseEntity<List<Apoderado>>getAll(){
		List<Apoderado> apoderado=service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(apoderado);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Apoderado>getById(@PathVariable("id") int id){
		Apoderado apoderado=service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(apoderado);
	}
	
	@PostMapping 
	public ResponseEntity<Apoderado> create(@RequestBody Apoderado apoderado) {
		Apoderado apoderadoDb=service.create(apoderado);
		return ResponseEntity.status(HttpStatus.CREATED).body(apoderadoDb);
	}
	
	@PutMapping
	public ResponseEntity<Apoderado> update(@RequestBody Apoderado apoderado) {
		Apoderado apoderadoDb=service.update(apoderado);
		return ResponseEntity.status(HttpStatus.OK).body(apoderadoDb);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
	
	@GetMapping(value="/selectAlumno")
	 public ResponseEntity<List<Alumno>> selectAlumno(){
		 List<Alumno> alumnos= serviceAlumno.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(alumnos);
	 }
}
