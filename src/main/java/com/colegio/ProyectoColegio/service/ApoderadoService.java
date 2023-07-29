package com.colegio.ProyectoColegio.service;

import java.util.List;

import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Apoderado;

public interface ApoderadoService {

	public List<Apoderado>findAll();
	public Apoderado findById(int id);
	
	public Apoderado findByNombre(String nombre);
	public List<Apoderado>findByNombreContaining(String nombre);
	
	public Apoderado create(Apoderado obj);
	public Apoderado update(Apoderado obj);
	public int delete(int id);
	public List<Alumno>selectAlumno();
	
}
