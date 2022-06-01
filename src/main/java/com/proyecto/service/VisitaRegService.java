package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Visita;
import com.proyecto.entidad.VisitaReg;

public interface VisitaRegService {
	
	public abstract List<VisitaReg> listaVisitaReg();
	public abstract VisitaReg insertaActualizaVisitaReg(VisitaReg obj);
	public abstract List<VisitaReg> listaVisitaPorNombreDniEstado(String nom_vis, String dni_vis, int estado_visreg);
	public abstract boolean validarVisitanteActivo(int cod_vis);
	
}
