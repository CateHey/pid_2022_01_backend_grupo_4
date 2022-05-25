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
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fech_ingr_visreg;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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

	public int getCod_visreg() {
		return cod_visreg;
	}

	public void setCod_visreg(int cod_visreg) {
		this.cod_visreg = cod_visreg;
	}

	public int getEstado_visreg() {
		return estado_visreg;
	}

	public void setEstado_visreg(int estado_visreg) {
		this.estado_visreg = estado_visreg;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFech_ingr_visreg() {
		return fech_ingr_visreg;
	}

	public void setFech_ingr_visreg(Date fech_ingr_visreg) {
		this.fech_ingr_visreg = fech_ingr_visreg;
	}

	public Date getFech_sal_visreg() {
		return fech_sal_visreg;
	}

	public void setFech_sal_visreg(Date fech_sal_visreg) {
		this.fech_sal_visreg = fech_sal_visreg;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
}
	
