package com.colegio.ProyectoColegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.repository.AulaRepository;
import com.colegio.ProyectoColegio.service.AulaService;

@Service
public class AulaServiceImpl implements AulaService {
	@Autowired
	private AulaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Aula> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findByNumero(String numero) {
		try {
			return repository.findByNumero(numero);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Aula> findByNumeroContaining(String numero) {
		try {
			return repository.findByNumeroContaining(numero);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Aula> findByCapacidadContaining(int capacidad) {
		try {
			return repository.findByCapacidadContaining(capacidad);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findByCapacidad(int capacidad) {
		try {
			return repository.findByCapacidad(capacidad);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public Aula create(Aula obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Aula update(Aula obj) {
		try {
			Aula aulaDb=repository.findById(obj.getId()).orElse(null);
			if(aulaDb==null) {
				return null;
			}
			aulaDb.setNumero(obj.getNumero());
			aulaDb.setCapacidad(obj.getCapacidad());
			return repository.save(aulaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Aula aulaDb=repository.findById(id).orElse(null);
			if(aulaDb==null) {
				return 0;
			}else {
				repository.delete(aulaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
}
