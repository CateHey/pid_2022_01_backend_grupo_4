package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Boleta;

public interface BoletaService {
	public abstract List<Boleta> listaBoleta();
	public abstract Boleta insertaActualizaBoleta(Boleta obj);
	public abstract List<Boleta> listaBoletaPorNombreDniServicioEstado(String nom_prop, String dni_prop, String nom_serv, int est_bol);
}
