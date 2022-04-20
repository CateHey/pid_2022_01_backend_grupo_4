package com.proyecto.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROPIETARIO")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_prop;
    private String nom_prop;
    private String ape_prop;
    private String dni_prop;
    private String tel_prop;
    private String email_prop;
    private int cod_usu;
    private int cod_dep;
    private String fech_prop;
    private String hora_prop;
	public int getCod_prop() {
		return cod_prop;
	}
	public void setCod_prop(int cod_prop) {
		this.cod_prop = cod_prop;
	}
	public String getNom_prop() {
		return nom_prop;
	}
	public void setNom_prop(String nom_prop) {
		this.nom_prop = nom_prop;
	}
	public String getApe_prop() {
		return ape_prop;
	}
	public void setApe_prop(String ape_prop) {
		this.ape_prop = ape_prop;
	}
	public String getDni_prop() {
		return dni_prop;
	}
	public void setDni_prop(String dni_prop) {
		this.dni_prop = dni_prop;
	}
	public String getTel_prop() {
		return tel_prop;
	}
	public void setTel_prop(String tel_prop) {
		this.tel_prop = tel_prop;
	}
	public String getEmail_prop() {
		return email_prop;
	}
	public void setEmail_prop(String email_prop) {
		this.email_prop = email_prop;
	}
	public int getCod_usu() {
		return cod_usu;
	}
	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}
	public int getCod_dep() {
		return cod_dep;
	}
	public void setCod_dep(int cod_dep) {
		this.cod_dep = cod_dep;
	}
	public String getFech_prop() {
		return fech_prop;
	}
	public void setFech_prop(String fech_prop) {
		this.fech_prop = fech_prop;
	}
	public String getHora_prop() {
		return hora_prop;
	}
	public void setHora_prop(String hora_prop) {
		this.hora_prop = hora_prop;
	}
    
    

}
