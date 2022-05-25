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
@Table(name = "MASCOTA")
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_mas;
	private String nom_mas;
	private String raza_mas;
	private String tipo_mas;

	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prop")
	private Propietario propietario;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fec_reg_mas;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usu")
	private Usuario usuario;

	public int getCod_mas() {
		return cod_mas;
	}

	public void setCod_mas(int cod_mas) {
		this.cod_mas = cod_mas;
	}

	public String getNom_mas() {
		return nom_mas;
	}

	public void setNom_mas(String nom_mas) {
		this.nom_mas = nom_mas;
	}

	public String getRaza_mas() {
		return raza_mas;
	}

	public void setRaza_mas(String raza_mas) {
		this.raza_mas = raza_mas;
	}

	public String getTipo_mas() {
		return tipo_mas;
	}

	public void setTipo_mas(String tipo_mas) {
		this.tipo_mas = tipo_mas;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Date getFec_reg_mas() {
		return fec_reg_mas;
	}

	public void setFec_reg_mas(Date fec_reg_mas) {
		this.fec_reg_mas = fec_reg_mas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
