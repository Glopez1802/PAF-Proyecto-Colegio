package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.ProyectoColegio.entity.Apoderado;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer> {

	List<Apoderado> findByNombreContaining(String texto);
	Apoderado findByNombre(String texto);
	
}
