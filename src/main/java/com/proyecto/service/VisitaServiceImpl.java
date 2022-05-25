package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Visita;
import com.proyecto.repository.VisitaRepository;

@Service
public class VisitaServiceImpl implements VisitaService{

	@Autowired
	private VisitaRepository repository;
	
	@Override
	public Visita insertaActualizaVisita(Visita obj) {
		return repository.save(obj);
	}
	@Override
	public List<Visita> listaVisita(){
		return repository.findAll();
	}
	@Override
	public List<Visita> listaVisitaPorDni(String dni_vis) {
		return repository.listaVisitaPorDni(dni_vis);
	}
	@Override
	public List<Visita> listaVisitaPorDniNom(String dni_vis, String nom_vis) {
		return repository.listaVisitaPorDniNom(dni_vis, nom_vis);
	}
	
}
