package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.ProyectoColegio.entity.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	List<Aula> findByNumeroContaining(String texto);
	Aula findByNumero(String texto);
	List<Aula> findByCapacidadContaining(int capacidad);
	Aula findByCapacidad(int capacidad);
}
