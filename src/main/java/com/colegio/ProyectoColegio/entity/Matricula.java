package com.colegio.ProyectoColegio.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="matricula")
@EntityListeners(AuditingEntityListener.class)
public class Matricula {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@ManyToOne()
		@JoinColumn(name="alumno_id")
		private Alumno alumno;
		
		@ManyToOne()
		@JoinColumn(name="aula_id")
		private Aula  aula;
		
		@ManyToOne()
		@JoinColumn(name="horario_id")
		private Horario  horario;
		
		@ManyToOne()
		@JoinColumn(name="docente_id")
		private Docente docente;
	
		@Column(name="fechamatricula",nullable = false,length = 100)
		private String fechamatricula;
		
		@Column(name="created_at",nullable = false,updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		private Date createdAt;
		@Column(name="updated_at")
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date updatedAt;
		@Column(name="activo")
		private boolean activo;
}
