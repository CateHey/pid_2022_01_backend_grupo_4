package pid.proyecto.service;

import java.util.List;


import pid.proyecto.entidad.Departamento;

public interface DepartamentoService {
	public abstract List<Departamento> listaDepartamento();
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
}
