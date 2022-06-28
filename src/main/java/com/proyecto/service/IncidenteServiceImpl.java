package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Boleta;
import com.proyecto.entidad.Incidente;
import com.proyecto.entidad.VisitaReg;
import com.proyecto.repository.IncidenteRepository;

@Service
public class IncidenteServiceImpl implements IncidenteService{
	
	@Autowired
	private IncidenteRepository repository;

	@Override
	public List<Incidente> listaIncidentes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Incidente insertaActualizaIncidentes(Incidente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaBoletaPorEdiDepEstCau(String nom_edi, String num_dep, int estado_inc, String nom_incd) {
		// TODO Auto-generated method stub
		return repository.listaIncidentePorEdificioDepartamentoEstado(nom_edi, num_dep, estado_inc, nom_incd);
	}

	@Override
	public boolean validarIncidentesPendientes(String nom_edi, String num_dep , String nom_incd) {
		// TODO Auto-generated method stub
		List<Incidente> lst = repository.listaParaValidar(nom_edi, num_dep, nom_incd);
		return lst.size() > 0 ? true : false;
	}

}
