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
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.service.impl.AlumnoServiceImpl;
import com.colegio.ProyectoColegio.service.impl.DocenteServiceImpl;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
 @Autowired
	private AlumnoServiceImpl service;
 @Autowired
	private DocenteServiceImpl serviceDocente;
 @GetMapping() 
	public ResponseEntity<List<Alumno>> getAll(){
		List<Alumno> alumno= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alumno);
	}
 @GetMapping(value="/{id}") 
	public ResponseEntity<Alumno> getById(@PathVariable("id") int id) {
		Alumno alumno = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(alumno);
	}
 @PostMapping 
	public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
		Alumno alumnoDb=service.create(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
 @PutMapping
	public ResponseEntity<Alumno> update(@RequestBody Alumno alumno) {
	 Alumno alumnoDb=service.update(alumno);
		return ResponseEntity.status(HttpStatus.OK).body(alumnoDb);
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
