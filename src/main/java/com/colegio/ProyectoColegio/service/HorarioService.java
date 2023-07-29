package com.colegio.ProyectoColegio.service;
import java.util.List;

import com.colegio.ProyectoColegio.entity.Horario;

public interface HorarioService {
	public List<Horario> findAll();
	public Horario findById(int id);
	public Horario findByTurno(String turno);
	public List<Horario> findByTurnoContaining(String turno);
	public Horario findByDia(String dia);
	public List<Horario> findByDiaContaining(String dia);
	public Horario findByHoraInicio(String horaInicio);
	public List<Horario> findByHoraInicioContaining(String horaInicio);
	public Horario findByHoraFinal(String horaFinal);
	public List<Horario> findByHoraFinalContaining(String horaFinal);
	public Horario create(Horario obj);
	public Horario update(Horario obj);
	public int delete(int id);
}
