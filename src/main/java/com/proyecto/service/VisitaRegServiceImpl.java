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
	
	
}
