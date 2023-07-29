package com.colegio.ProyectoColegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Apoderado;
import com.colegio.ProyectoColegio.repository.AlumnoRepository;
import com.colegio.ProyectoColegio.repository.ApoderadoRepository;
import com.colegio.ProyectoColegio.service.ApoderadoService;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

	@Autowired
	private ApoderadoRepository repository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Apoderado> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Apoderado findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public Apoderado update(Apoderado obj) {
		try {
			Apoderado apoderadoDb=repository.findById(obj.getId()).orElse(null);
			if (apoderadoDb==null) {
				return null;
			}
			apoderadoDb.setNombre(obj.getNombre());
			apoderadoDb.setAlumno(obj.getAlumno());
			
			return repository.save(apoderadoDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Apoderado create(Apoderado obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Apoderado apoderadoDb=repository.findById(id).orElse(null);
			if(apoderadoDb==null) {
				return 0;
			}else {
				repository.delete(apoderadoDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Apoderado> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Alumno> selectAlumno() {
		try {
			return alumnoRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Apoderado findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	

}
