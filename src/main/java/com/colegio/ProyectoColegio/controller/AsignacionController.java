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

import com.colegio.ProyectoColegio.entity.Asignacion;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.service.impl.AsignacionServiceImpl;
import com.colegio.ProyectoColegio.service.impl.AulaServiceImpl;
import com.colegio.ProyectoColegio.service.impl.CursoServiceImpl;
import com.colegio.ProyectoColegio.service.impl.DocenteServiceImpl;
import com.colegio.ProyectoColegio.service.impl.HorarioServiceImpl;

@RestController
@RequestMapping("/api/asignacion")
public class AsignacionController {
 @Autowired
	private AsignacionServiceImpl service;
 @Autowired
	private DocenteServiceImpl serviceDocente;
 @Autowired
	private AulaServiceImpl serviceAula;
 @Autowired
	private HorarioServiceImpl serviceHorario;
 @Autowired
	private CursoServiceImpl serviceCurso;
 
 
 @GetMapping() 
	public ResponseEntity<List<Asignacion>> getAll(){
		List<Asignacion> asignacion= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(asignacion);
	}
 @GetMapping(value="/{id}") 
	public ResponseEntity<Asignacion> getById(@PathVariable("id") int id) {
	 Asignacion asignacion = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(asignacion);
	}
 @PostMapping 
	public ResponseEntity<Asignacion> create(@RequestBody Asignacion asignacion) {
		Asignacion asignacionDb=service.create(asignacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(asignacionDb);
	}
 @PutMapping
	public ResponseEntity<Asignacion> update(@RequestBody Asignacion asignacion) {
	 Asignacion asignacionDb=service.update(asignacion);
		return ResponseEntity.status(HttpStatus.OK).body(asignacionDb);
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
 
 @GetMapping(value="/selectAula")
 public ResponseEntity<List<Aula>> selectAula(){
	 List<Aula> aulas= serviceAula.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(aulas);
 }
 
 @GetMapping(value="/selectHorario")
 public ResponseEntity<List<Horario>> selectHorario(){
	 List<Horario> horarios= serviceHorario.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(horarios);
 }
 
 @GetMapping(value="/selectCurso")
 public ResponseEntity<List<Curso>> selectCurso(){
	 List<Curso> cursos= serviceCurso.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
 }
}
