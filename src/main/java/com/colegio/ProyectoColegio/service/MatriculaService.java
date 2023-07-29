package com.colegio.ProyectoColegio.service;

import java.util.List; 

import com.colegio.ProyectoColegio.entity.Matricula;
import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;


public interface MatriculaService {
public List<Matricula>findAll();
public Matricula findById(int id);

public Matricula create(Matricula obj);
public Matricula update(Matricula obj);

public int delete(int id);
public List<Alumno> selectAlumno();
public List<Aula> selectAula();
public List<Horario> selectHorario();
public List<Docente> selectDocente();

}
