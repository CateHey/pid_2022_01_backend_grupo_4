package com.proyecto.service;

import java.util.Date;
import java.util.List;

import com.proyecto.entidad.Incidente;

public interface IncidenteService {
	
	public abstract List<Incidente> listaIncidentes();
	public abstract Incidente insertaActualizaIncidentes(Incidente obj);
	public abstract List<Incidente> listaIncidentePorEdiDepEstCau(int cod_edi, int cod_dep , int estado_inc, int cod_incd);
	public abstract boolean validarIncidentesPendientes(int cod_edi, int cod_dep , int cod_incd);

}
