package com.colegio.ProyectoColegio.service;
import java.util.List; 

import com.colegio.ProyectoColegio.entity.Docente;

public interface DocenteService {
	public List<Docente> findAll();
	public Docente findById(int id);
	public Docente findByNombre(String nombre);
	public List<Docente> findByNombreContaining(String nombre);
	//public Docente findByApellidoPaterno(String apellidopaterno);
	//public List<Docente> findByApellidoPaternoContaining(String apellidopaterno);
	//public Docente findByApellidoMaterno(String apellidomaterno);
	//public List<Docente> findByApellidoMaternoContaining(String apellidomaterno);
	public Docente create(Docente obj);
	public Docente update(Docente obj);
	public int delete(int id);
}
