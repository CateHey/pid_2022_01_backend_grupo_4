package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.VisitaReg;
import com.proyecto.repository.VisitaRegRepository;

@Service
public class VisitaRegServiceImpl implements VisitaRegService{

	@Autowired
	private VisitaRegRepository repository;

	@Override
	public List<VisitaReg> listaVisitaReg() {
		return repository.findAll();
	}

	@Override
	public VisitaReg insertaActualizaVisitaReg(VisitaReg obj) {
		return repository.save(obj);
	}

	@Override
	public List<VisitaReg> listaVisitaPorNombreDniEstado(String nom_vis, String dni_vis, int estado_visreg) {
		return repository.listaVisitaPorNombreDniEstado(nom_vis, dni_vis, estado_visreg);
	}
	
	@Override
	public boolean validarVisitanteActivo(int cod_vis) {
		List<VisitaReg> lst = repository.validarVisitanteActivo(cod_vis);
		return lst.size() > 0 ? true : false;
	}
}
