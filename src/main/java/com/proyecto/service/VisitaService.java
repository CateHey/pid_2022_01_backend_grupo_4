package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Visita;

public interface VisitaService {
	
	public abstract List<Visita> listaVisita();
	public abstract Visita insertaActualizaVisita(Visita obj);
	public abstract List<Visita> listaVisitaPorDni(String dni_vis);
	public abstract List<Visita> listaVisitaPorDniNom(String dni_vis, String nom_vis);

}
