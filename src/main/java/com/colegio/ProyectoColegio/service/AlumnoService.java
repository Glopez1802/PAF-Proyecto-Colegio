package com.colegio.ProyectoColegio.service;

import java.util.List;

import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Docente;

public interface AlumnoService {
public List<Alumno>findAll();
public Alumno findById(int id);
public Alumno findByNombre(String nombre);
public List<Alumno>findByNombreContaining(String nombre);
public Alumno create(Alumno obj);
public Alumno update(Alumno obj);
public int delete(int id);
public List<Docente> selectDocente();
}
