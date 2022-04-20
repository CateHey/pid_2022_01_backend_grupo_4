package com.proyecto.service;

import java.util.List;


import com.proyecto.entidad.Departamento;

public interface DepartamentoService {
	public abstract List<Departamento> listaDepartamento();
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
}
