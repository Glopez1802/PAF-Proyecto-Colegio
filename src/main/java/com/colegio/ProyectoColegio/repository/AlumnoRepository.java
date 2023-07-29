package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

	List<Alumno> findByNombreContaining(String texto);
	Alumno findByNombre(String texto);
}
