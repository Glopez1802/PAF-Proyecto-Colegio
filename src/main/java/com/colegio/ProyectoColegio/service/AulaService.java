package com.colegio.ProyectoColegio.service;
import java.util.List;

import com.colegio.ProyectoColegio.entity.Aula;

public interface AulaService {
	public List<Aula> findAll();
	public Aula findById(int id);
	public Aula findByNumero(String numero);
	public List<Aula> findByNumeroContaining(String numero);
	public Aula findByCapacidad(int capacidad);
	public List<Aula> findByCapacidadContaining(int capacidad);
	public Aula create(Aula obj);
	public Aula update(Aula obj);
	public int delete(int id);
}
