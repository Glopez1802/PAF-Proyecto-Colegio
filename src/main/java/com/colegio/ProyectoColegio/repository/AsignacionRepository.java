package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Asignacion;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer>{

	List<Asignacion> findByidContaining(Integer texto);
	Asignacion findByid(Integer texto);
}
