package pid.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pid.proyecto.entidad.Departamento;


public interface DepartamentoService {
	public abstract List<Departamento> listaDepartamento();
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
}
