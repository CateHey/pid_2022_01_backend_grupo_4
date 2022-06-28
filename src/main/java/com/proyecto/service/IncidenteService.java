package com.proyecto.service;

import java.util.Date;
import java.util.List;

import com.proyecto.entidad.Incidente;

public interface IncidenteService {
	
	public abstract List<Incidente> listaIncidentes();
	public abstract Incidente insertaActualizaIncidentes(Incidente obj);
	public abstract List<Incidente> listaBoletaPorEdiDepEstCau(String cod_edi, String cod_dep , int estado_inc, String cod_incd);
	public abstract boolean validarIncidentesPendientes(String cod_edi, String cod_dep , String estado_inc);


}
