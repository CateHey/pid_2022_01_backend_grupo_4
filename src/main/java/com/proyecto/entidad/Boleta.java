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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BOLETA")
public class Boleta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_bol;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_serv")
	private Servicio servicio;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prop")
	private Propietario propietario;
	
	private int anio;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_bol;
	
	private int est_bol;
	
	@Transient
	private String auxCodigo;

	public int getCod_bol() {
		return cod_bol;
	}

	public void setCod_bol(int cod_bol) {
		this.cod_bol = cod_bol;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Date getFecha_bol() {
		return fecha_bol;
	}

	public void setFecha_bol(Date fecha_bol) {
		this.fecha_bol = fecha_bol;
	}

	public int getEst_bol() {
		return est_bol;
	}

	public void setEst_bol(int est_bol) {
		this.est_bol = est_bol;
	}
	
	public String getAuxCodigo() {
		return auxCodigo;
	}

	public void setAuxCodigo(String auxCodigo) {
		this.auxCodigo = auxCodigo;
	}
	
}
