package com.proyecto.service;

import java.util.Date;
import java.util.List;

import com.proyecto.entidad.Boleta;

public interface BoletaService {
	public abstract List<Boleta> listaBoleta();
	public abstract Boleta insertaActualizaBoleta(Boleta obj);
	public abstract List<Boleta> listaBoletaPorNombreDniServicioEstado(String nom_prop, String dni_prop, String nom_serv, int est_bol);
	public abstract List<Boleta> listaBoletaPorServicioPropietario(int cod_serv, int cod_prop, int anio);
	public abstract List<Boleta> obtenerBoletaRegistros(Boleta obj, List<Date> lstFechas);
	public abstract boolean validarBoletaPendientes(int cod_serv, int cod_prop, int anio);
}
