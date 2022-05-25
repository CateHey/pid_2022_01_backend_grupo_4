package com.proyecto.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

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

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_dep")
	private Departamento departamento;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date fech_reg_prop;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usu")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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

	public Date getFech_reg_prop() {
		return fech_reg_prop;
	}

	public void setFech_reg_prop(Date fech_reg_prop) {
		this.fech_reg_prop = fech_reg_prop;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
