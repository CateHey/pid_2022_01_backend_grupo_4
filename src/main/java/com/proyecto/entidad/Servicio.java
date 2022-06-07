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
@Table(name = "SERVICIO")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_serv;
	private String nom_serv;
	public int getCod_serv() {
		return cod_serv;
	}
	public void setCod_serv(int cod_serv) {
		this.cod_serv = cod_serv;
	}
	public String getNom_serv() {
		return nom_serv;
	}
	public void setNom_serv(String nom_serv) {
		this.nom_serv = nom_serv;
	}
	
	

}
