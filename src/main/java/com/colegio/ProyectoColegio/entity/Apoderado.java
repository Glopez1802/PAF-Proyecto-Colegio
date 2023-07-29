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
@Table(name="apoderado")
@EntityListeners(AuditingEntityListener.class)
public class Apoderado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	
	@Column(name="apellidopaterno",nullable = false,length = 50)
	private String apellidopaterno;
	
	@Column(name="apellidomaterno",nullable = false,length = 50)
	private String apellidomaterno;
	
	@Column(name="dni",nullable = false,length = 50)
	private String dni;
	
	@Column(name="telefono",nullable = false,length = 100)
	private String telefono;
	
	@Column(name="ocupacion",nullable = false,length = 100)
	private String ocupacion;
	
	@Column(name="direccion",nullable = false,length = 100)
	private String direccion;
	
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
	
	@ManyToOne()
	@JoinColumn(name="alumno_id")
	private Alumno alumno;
}
