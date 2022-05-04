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
@Table(name = "VISITA")
public class Visita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_vis;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fech_vis;
	private String nom_vis;
	private String ape_vis;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechanac_vis;
	private String dni_vis;
	private String correo_vis;
	private String tel_vis;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_dep")
	private Departamento cod_dep;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usu")
	private Usuario usuario;
	
	public int getCod_vis() {
		return cod_vis;
	}
	public void setCod_vis(int cod_vis) {
		this.cod_vis = cod_vis;
	}
	public Date getFech_vis() {
		return fech_vis;
	}
	public void setFech_vis(Date fech_vis) {
		this.fech_vis = fech_vis;
	}
	public String getNom_vis() {
		return nom_vis;
	}
	public void setNom_vis(String nom_vis) {
		this.nom_vis = nom_vis;
	}
	public String getApe_vis() {
		return ape_vis;
	}
	public void setApe_vis(String ape_vis) {
		this.ape_vis = ape_vis;
	}
	public Date getFechanac_vis() {
		return fechanac_vis;
	}
	public void setFechanac_vis(Date fechanac_vis) {
		this.fechanac_vis = fechanac_vis;
	}
	public String getDni_vis() {
		return dni_vis;
	}
	public void setDni_vis(String dni_vis) {
		this.dni_vis = dni_vis;
	}
	public String getCorreo_vis() {
		return correo_vis;
	}
	public void setCorreo_vis(String correo_vis) {
		this.correo_vis = correo_vis;
	}
	public String getTel_vis() {
		return tel_vis;
	}
	public void setTel_vis(String tel_vis) {
		this.tel_vis = tel_vis;
	}
	public Departamento getCod_dep() {
		return cod_dep;
	}
	public void setCod_dep(Departamento cod_dep) {
		this.cod_dep = cod_dep;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
