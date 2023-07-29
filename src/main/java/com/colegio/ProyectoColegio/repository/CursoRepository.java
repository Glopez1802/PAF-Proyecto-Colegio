package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Curso;




@Repository
public interface CursoRepository  extends JpaRepository<Curso, Integer>{
	List<Curso> findByNombreContaining(String texto);
	Curso findByNombre(String texto);
}
