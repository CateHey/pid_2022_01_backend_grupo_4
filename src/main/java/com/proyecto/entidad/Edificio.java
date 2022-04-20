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
@Table(name = "EDIFICIO")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_edi;

	private String nom_edi;

	public int getCod_edi() {
		return cod_edi;
	}

	public void setCod_edi(int cod_edi) {
		this.cod_edi = cod_edi;
	}

	public String getNom_edi() {
		return nom_edi;
	}

	public void setNom_edi(String nom_edi) {
		this.nom_edi = nom_edi;
	}

	
}
