package com.colegio.ProyectoColegio.service;

import java.util.List;

import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;



public interface CursoService {
	public List<Curso> findAll();
	public Curso findById(int id);
	public Curso findByNombre(String nombre);
	public List<Curso> findByNombreContaining(String nombre);
	public Curso create(Curso obj);
	public Curso update(Curso obj);
	public int delete(int id);
	public List<Docente> selectDocente();
}
