package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Visita;

public interface VisitaService {
	
	public abstract List<Visita> listaVisita();
	public abstract Visita insertaActualizaVisita(Visita obj);

}
