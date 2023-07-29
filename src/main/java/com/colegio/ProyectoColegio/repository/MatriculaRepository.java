package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

	List<Matricula> findByidContaining(Integer texto);
	Matricula findByid(Integer texto);
}
