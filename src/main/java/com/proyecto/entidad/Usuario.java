package com.proyecto.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_usu;
	private String nom_usu;
	private String ape_usu;
	private String dni_usu;
	private String tel_usu;
	private String email_usu;
	private String pass_usu;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fech_reg_usu;

	public int getCod_usu() {
		return cod_usu;
	}

	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public String getApe_usu() {
		return ape_usu;
	}

	public void setApe_usu(String ape_usu) {
		this.ape_usu = ape_usu;
	}

	public String getDni_usu() {
		return dni_usu;
	}

	public void setDni_usu(String dni_usu) {
		this.dni_usu = dni_usu;
	}

	public String getTel_usu() {
		return tel_usu;
	}

	public void setTel_usu(String tel_usu) {
		this.tel_usu = tel_usu;
	}

	public String getEmail_usu() {
		return email_usu;
	}

	public void setEmail_usu(String email_usu) {
		this.email_usu = email_usu;
	}

	public String getPass_usu() {
		return pass_usu;
	}

	public void setPass_usu(String pass_usu) {
		this.pass_usu = pass_usu;
	}

	public Date getFech_reg_usu() {
		return fech_reg_usu;
	}

	public void setFech_reg_usu(Date fech_reg_usu) {
		this.fech_reg_usu = fech_reg_usu;
	}
	
}
