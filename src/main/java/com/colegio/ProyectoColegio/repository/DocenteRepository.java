package com.colegio.ProyectoColegio.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
	List<Docente> findByNombreContaining(String texto);
	Docente findByNombre(String texto);
	//List<Docente> findByApellidoPaternoContaining(String apellidopaterno);
	//Docente findByApellidoPaterno(String apellidopaterno);	
	
}
