package com.colegio.ProyectoColegio.service;

import java.util.List;

import com.colegio.ProyectoColegio.entity.Asignacion;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;

public interface AsignacionService {
public List<Asignacion>findAll();
public Asignacion findById(int id);
public Asignacion create(Asignacion obj);
public Asignacion update(Asignacion obj);
public int delete(int id);
public List<Docente> selectDocente();
public List<Aula> selectAula();
public List<Horario> selectHorario();
public List<Curso> selectCurso();
}
