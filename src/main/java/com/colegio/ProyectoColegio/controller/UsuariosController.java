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

import com.colegio.ProyectoColegio.entity.Usuario;
import com.colegio.ProyectoColegio.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
	@Autowired
	private UsuarioServiceImpl service;
	
	//localhost:8091/api/Usuario (GET)
	@GetMapping() 
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> usuarios= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	//localhost:8091/api/Usuario/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
		Usuario usuarios = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	//localhost:8091/api/Usuario (POST)
	@PostMapping 
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuarios) {
		Usuario usuariosDb=service.create(usuarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosDb);
	}
	
	//localhost:8091/api/Usuario/1 (PUT)
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuarios) {
		Usuario usuariosDb=service.update(usuarios);
		return ResponseEntity.status(HttpStatus.OK).body(usuariosDb);
	}
	
	//localhost:8091/api/usuario/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
