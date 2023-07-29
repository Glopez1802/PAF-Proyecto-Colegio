package com.colegio.ProyectoColegio.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Matricula;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.entity.Alumno;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.repository.MatriculaRepository;
import com.colegio.ProyectoColegio.repository.AlumnoRepository;
import com.colegio.ProyectoColegio.repository.AulaRepository;
import com.colegio.ProyectoColegio.repository.DocenteRepository;
import com.colegio.ProyectoColegio.repository.HorarioRepository;
import com.colegio.ProyectoColegio.service.MatriculaService;

@Service
public  class MatriculaServiceImpl implements MatriculaService{
	@Autowired
	private MatriculaRepository repository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AulaRepository aulaRepository;
	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findById(int id) {
		try {
			return  repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	@Transactional
	public Matricula create(Matricula obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public Matricula update(Matricula obj) {
		try {
			Matricula matriculaDb=repository.findById(obj.getId()).orElse(null);
		if(matriculaDb==null) {
			return null;
		}
		
		matriculaDb.setAlumno(obj.getAlumno());
		//matriculaDb.setNombre(obj.getNombre());
		matriculaDb.setAula(obj.getAula());
		//matriculaDb.setAlumno(obj.getAlumno());
		matriculaDb.setHorario(obj.getHorario());
		matriculaDb.setDocente(obj.getDocente());
		return repository.save(matriculaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Matricula matriculaDb=repository.findById(id).orElse(null);
			if(matriculaDb==null) {
				return 0;
			}else {
				repository.delete(matriculaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
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
	@Transactional(readOnly=true)
	public List<Docente> selectDocente() {
		
		try {
			return docenteRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Aula> selectAula() {
		
		try {
			return aulaRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Horario> selectHorario() {
		
		try {
			return horarioRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	

}
