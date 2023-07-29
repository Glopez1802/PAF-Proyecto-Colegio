package com.colegio.ProyectoColegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.colegio.ProyectoColegio.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
	List<Horario> findByTurnoContaining(String texto);
	Horario findByTurno(String texto);
	List<Horario> findByDiaContaining(String dia);
	Horario findByDia(String dia);
	Horario findByHoraInicio(String horaInicio);
	Horario findByHoraFinal(String horaFinal);
	List<Horario> findByHoraFinalContaining(String horaFinal);
	List<Horario> findByHoraInicioContaining(String horaInicio);
}
