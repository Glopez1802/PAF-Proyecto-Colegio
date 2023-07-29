package com.colegio.ProyectoColegio.service.impl;

import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Asignacion;
import com.colegio.ProyectoColegio.entity.Aula;
import com.colegio.ProyectoColegio.entity.Curso;
import com.colegio.ProyectoColegio.entity.Docente;
import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.repository.AsignacionRepository;
import com.colegio.ProyectoColegio.repository.AulaRepository;
import com.colegio.ProyectoColegio.repository.CursoRepository;
import com.colegio.ProyectoColegio.repository.DocenteRepository;
import com.colegio.ProyectoColegio.repository.HorarioRepository;
import com.colegio.ProyectoColegio.service.AsignacionService;

@Service
public  class AsignacionServiceImpl implements AsignacionService{
	
	@Autowired
	private AsignacionRepository repository;

	@Autowired
	private DocenteRepository docenteRepository;
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Asignacion> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Asignacion findById(int id) {
		try {
			return  repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public Asignacion create(Asignacion obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public Asignacion update(Asignacion obj) {
		try {
			Asignacion asignacionDb=repository.findById(obj.getId()).orElse(null);
		if(asignacionDb==null) {
			return null;
		}
		asignacionDb.setDocente(obj.getDocente());
		asignacionDb.setAula(obj.getAula());
		asignacionDb.setHorario(obj.getHorario());
		
		return repository.save(asignacionDb);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Asignacion asignacionDb=repository.findById(id).orElse(null);
			if(asignacionDb==null) {
				return 0;
			}else {
				repository.delete(asignacionDb);
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
	
	@Override
	@Transactional(readOnly=true)
	public List<Curso> selectCurso() {
		
		try {
			return cursoRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	

}
