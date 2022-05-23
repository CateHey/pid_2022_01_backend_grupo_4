package com.proyecto.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VISITA_REG")
public class VisitaReg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_visreg;
	
	private int estado_visreg;
	
	private String comentario; 
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="America/Lima")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fech_ingr_visreg;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="America/Lima")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fech_sal_visreg;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_vis")
	private Visita visita;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prop")
	private Propietario propietario;
}
	
