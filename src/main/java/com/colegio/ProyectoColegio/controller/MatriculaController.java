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

import com.colegio.ProyectoColegio.entity.Matricula;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.service.impl.MatriculaServiceImpl;
import com.colegio.ProyectoColegio.service.impl.AlumnoServiceImpl;
import com.colegio.ProyectoColegio.service.impl.AulaServiceImpl;
import com.colegio.ProyectoColegio.service.impl.DocenteServiceImpl;
import com.colegio.ProyectoColegio.service.impl.HorarioServiceImpl;


@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {
 @Autowired
	private MatriculaServiceImpl service;
 @Autowired
	private AlumnoServiceImpl serviceAlumno;
 @Autowired
	private DocenteServiceImpl serviceDocente;
 @Autowired
	private AulaServiceImpl serviceAula;
 @Autowired
	private HorarioServiceImpl serviceHorarios;
 
 @GetMapping() 
	public ResponseEntity<List<Matricula>> getAll(){
		List<Matricula> matricula= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(matricula);
	}
 @GetMapping(value="/{id}") 
	public ResponseEntity<Matricula> getById(@PathVariable("id") int id) {
	 Matricula matricula = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(matricula);
	}
 @PostMapping 
	public ResponseEntity<Matricula> create(@RequestBody Matricula matricula) {
	 	Matricula matriculaDb=service.create(matricula);
		return ResponseEntity.status(HttpStatus.CREATED).body(matriculaDb);
	}
 @PutMapping
	public ResponseEntity<Matricula> update(@RequestBody Matricula matricula) {
	 Matricula matriculaDb=service.update(matricula);
		return ResponseEntity.status(HttpStatus.OK).body(matriculaDb);
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
 @GetMapping(value="/selectDocente")
 public ResponseEntity<List<Docente>> selectDocente(){
	 List<Docente> docentes= serviceDocente.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(docentes);
 }
 @GetMapping(value="/selectAula")
 public ResponseEntity<List<Aula>> selectAula(){
	 List<Aula> aulas= serviceAula.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(aulas);
 }
 @GetMapping(value="/selectHorario")
 public ResponseEntity<List<Horario>> selectHorario(){
	 List<Horario> horarios= serviceHorarios.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(horarios);
 }
 
}
