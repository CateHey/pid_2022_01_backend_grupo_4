package com.proyecto.service;

import java.util.List;


import com.proyecto.entidad.Edificio;

public interface EdificioService {
	public abstract List<Edificio> listaEdificio();
	public abstract Edificio insertaActualizaEdificio(Edificio obj);
}
