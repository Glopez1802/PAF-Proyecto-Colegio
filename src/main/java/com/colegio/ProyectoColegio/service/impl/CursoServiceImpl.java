package com.colegio.ProyectoColegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.repository.CursoRepository;
import com.colegio.ProyectoColegio.repository.DocenteRepository;
import com.colegio.ProyectoColegio.service.CursoService;



@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoRepository repository;
	@Autowired DocenteRepository docenteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Curso findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Curso findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public Curso create(Curso obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	@Transactional
	public Curso update(Curso obj) {
		try {
			Curso cursoDb=repository.findById(obj.getId()).orElse(null);
			if(cursoDb==null) {
				return null;
			}
			cursoDb.setNombre(obj.getNombre());
			cursoDb.setDocente(obj.getDocente());
			
			return repository.save(cursoDb);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public int delete(int id) {
		try {
			Curso cursoDb=repository.findById(id).orElse(null);
			if(cursoDb==null) {
				return 0;
			}else {
				repository.delete(cursoDb);
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
