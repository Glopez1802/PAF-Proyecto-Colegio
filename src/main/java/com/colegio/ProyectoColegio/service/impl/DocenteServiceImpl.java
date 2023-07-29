package com.colegio.ProyectoColegio.service.impl;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.repository.DocenteRepository;
import com.colegio.ProyectoColegio.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
	@Autowired
	private DocenteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Docente findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Docente findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Docente> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	/*
	@Override
	@Transactional(readOnly = true)
	public Docente findByApellidoPaterno(String apellidopaterno) {
		try {
			return repository.findByApellidoPaterno(apellidopaterno);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Docente> findByApellidoPaternoContaining(String apellidopaterno) {
		try {
			return repository.findByApellidoPaternoContaining(apellidopaterno);
		} catch (Exception e) {
			return null;
		}
	}
	*/

	@Override
	@Transactional
	public Docente create(Docente obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Docente update(Docente obj) {
		try {
			Docente docenteDb=repository.findById(obj.getId()).orElse(null);
			if(docenteDb==null) {
				return null;
			}
			docenteDb.setNombre(obj.getNombre());
		    //docenteDb.setApellidopaterno(obj.getApellidopaterno());
			//docenteDb.setApellidomaterno(obj.getApellidomaterno());
			
			return repository.save(docenteDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Docente docenteDb=repository.findById(id).orElse(null);
			if(docenteDb==null) {
				return 0;
			}else {
				repository.delete(docenteDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
}
