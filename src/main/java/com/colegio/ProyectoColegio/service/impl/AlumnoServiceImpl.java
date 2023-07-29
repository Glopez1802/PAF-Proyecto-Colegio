package com.colegio.ProyectoColegio.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.repository.AlumnoRepository;
import com.colegio.ProyectoColegio.repository.DocenteRepository;
import com.colegio.ProyectoColegio.service.AlumnoService;

@Service
public  class AlumnoServiceImpl implements AlumnoService{
	@Autowired
	private AlumnoRepository repository;
	@Autowired
	private DocenteRepository docenteRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(int id) {
		try {
			return  repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public Alumno create(Alumno obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public Alumno update(Alumno obj) {
		try {
			Alumno alumnoDb=repository.findById(obj.getId()).orElse(null);
		if(alumnoDb==null) {
			return null;
		}
		alumnoDb.setNombre(obj.getNombre());
		alumnoDb.setApellidopaterno(obj.getApellidopaterno());
		alumnoDb.setApellidomaterno(obj.getApellidomaterno());
		alumnoDb.setEdad(obj.getEdad());
		alumnoDb.setSemestre(obj.getSemestre());
		alumnoDb.setCorreo(obj.getCorreo());
		alumnoDb.setTelefono(obj.getTelefono());
		alumnoDb.setDocente(obj.getDocente());
		return repository.save(alumnoDb);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Alumno alumnoDb=repository.findById(id).orElse(null);
			if(alumnoDb==null) {
				return 0;
			}else {
				repository.delete(alumnoDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Docente> selectDocente() {
		
		try {
			return docenteRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	

}
