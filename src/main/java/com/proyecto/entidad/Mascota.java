package com.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private int edad_mas;
	private String tipo_mas;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prop")
	private Propietario propietario;

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

	public int getEdad_mas() {
		return edad_mas;
	}

	public void setEdad_mas(int edad_mas) {
		this.edad_mas = edad_mas;
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
	

}
