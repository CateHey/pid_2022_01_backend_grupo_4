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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_dep;
	
	private String num_dep;
	
	private int metros_dep;
	
	private String tel_dep;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "cod_edi")
	private Edificio edificio;
	
	private double pre_dep;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fec_reg_dep;

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

    public int getCod_dep() {
        return cod_dep;
    }


    public void setCod_dep(int cod_dep) {
        this.cod_dep = cod_dep;
    }


    public int getMetros_dep() {
        return metros_dep;
    }


    public void setMetros_dep(int metros_dep) {
        this.metros_dep = metros_dep;
    }


    public String getTel_dep() {
        return tel_dep;
    }


    public void setTel_dep(String tel_dep) {
        this.tel_dep = tel_dep;
    }


    public Edificio getEdificio() {
        return edificio;
    }


    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }


    public double getPre_dep() {
        return pre_dep;
    }


    public void setPre_dep(double pre_dep) {
        this.pre_dep = pre_dep;
    }


    public Date getFec_reg_dep() {
        return fec_reg_dep;
    }


    public void setFec_reg_dep(Date fec_reg_dep) {
        this.fec_reg_dep = fec_reg_dep;
    }


    public String getNum_dep() {
        return num_dep;
    }


    public void setNum_dep(String num_dep) {
        this.num_dep = num_dep;
    }
}
