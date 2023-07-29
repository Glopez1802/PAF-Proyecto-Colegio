package com.colegio.ProyectoColegio.controller;

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

import java.util.List;

import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.service.impl.CursoServiceImpl;
import com.colegio.ProyectoColegio.service.impl.DocenteServiceImpl;


@RestController
@RequestMapping("/api/curso")
public class CursoController {
	
	@Autowired
	private CursoServiceImpl service;
	@Autowired
	private DocenteServiceImpl serviceDocente;
	
	
	@GetMapping()
	public ResponseEntity<List<Curso>> getAll(){
		List<Curso> curso = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	@GetMapping(value="/{id}") 
	public ResponseEntity<Curso> getById(@PathVariable("id") int id) {
		Curso curso = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	@PostMapping 
	public ResponseEntity<Curso> create(@RequestBody Curso curso) {
		Curso cursoDb=service.create(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoDb);
	}
	
	@PutMapping
	public ResponseEntity<Curso> update(@RequestBody Curso curso) {
		Curso cursoDb=service.update(curso);
		return ResponseEntity.status(HttpStatus.OK).body(cursoDb);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
	
	@GetMapping(value="/selectDocente")
	 public ResponseEntity<List<Docente>> selectDocente(){
		 List<Docente> docentes= serviceDocente.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(docentes);
	 }
}
