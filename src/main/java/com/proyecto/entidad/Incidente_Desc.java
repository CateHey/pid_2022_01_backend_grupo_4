package com.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INCIDENTE_DESC")
public class Incidente_Desc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_incd;
	private String nom_incd;
	public int getCod_incd() {
		return cod_incd;
	}
	public void setCod_incd(int cod_incd) {
		this.cod_incd = cod_incd;
	}
	public String getNom_incd() {
		return nom_incd;
	}
	public void setNom_incd(String nom_incd) {
		this.nom_incd = nom_incd;
	}
	
	
	
}
