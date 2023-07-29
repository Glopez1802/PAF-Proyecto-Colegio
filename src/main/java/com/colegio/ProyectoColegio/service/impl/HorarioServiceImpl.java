package com.colegio.ProyectoColegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.ProyectoColegio.entity.Horario;
import com.colegio.ProyectoColegio.repository.HorarioRepository;
import com.colegio.ProyectoColegio.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
	@Autowired
	private HorarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Horario> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findByTurno(String turno) {
		try {
			return repository.findByTurno(turno);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Horario> findByTurnoContaining(String turno) {
		try {
			return repository.findByTurnoContaining(turno);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Horario> findByDiaContaining(String dia) {
		try {
			return repository.findByDiaContaining(dia);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findByDia(String dia) {
		try {
			return repository.findByDia(dia);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	@Transactional
	public Horario create(Horario obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Horario update(Horario obj) {
		try {
			Horario horarioDb=repository.findById(obj.getId()).orElse(null);
			if(horarioDb==null) {
				return null;
			}
			horarioDb.setTurno(obj.getTurno());
			horarioDb.setDia(obj.getDia());
			horarioDb.setHoraInicio(obj.getHoraInicio());
			return repository.save(horarioDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Horario horarioDb=repository.findById(id).orElse(null);
			if(horarioDb==null) {
				return 0;
			}else {
				repository.delete(horarioDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Horario findByHoraFinal(String horaFinal) {
		try {
			return repository.findByHoraFinal(horaFinal);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Horario> findByHoraFinalContaining(String horaFinal) {
		try {
			return repository.findByHoraFinalContaining(horaFinal);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public List<Horario> findByHoraInicioContaining(String horaInicio) {
		try {
			return repository.findByHoraInicioContaining(horaInicio);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findByHoraInicio(String horaInicio) {
		try {
			return repository.findByHoraInicio(horaInicio);
		} catch (Exception e) {
			return null;
		}
	}
}
