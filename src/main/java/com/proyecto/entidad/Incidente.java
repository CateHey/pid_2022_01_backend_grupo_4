package com.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INCIDENTE")
public class Incidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_inc;
	
	private String desc_inc;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_dep")
	private Departamento departamento;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_edi")
	private Edificio edificio;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_incd")
	private Incidente_Desc incidente_desc;

	private int estado_inc;
	
	@Transient
	private String auxCodigo;

	public int getCod_inc() {
		return cod_inc;
	}

	public void setCod_inc(int cod_inc) {
		this.cod_inc = cod_inc;
	}

	public String getDesc_inc() {
		return desc_inc;
	}

	public void setDesc_inc(String desc_inc) {
		this.desc_inc = desc_inc;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Incidente_Desc getIncidente_desc() {
		return incidente_desc;
	}

	public void setIncidente_desc(Incidente_Desc incidente_desc) {
		this.incidente_desc = incidente_desc;
	}

	public int getEstado_inc() {
		return estado_inc;
	}

	public void setEstado_inc(int estado_inc) {
		this.estado_inc = estado_inc;
	}
	
	public String getAuxCodigo() {
		return auxCodigo;
	}

	public void setAuxCodigo(String auxCodigo) {
		this.auxCodigo = auxCodigo;
	}
	
}
