package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Edificio;
import com.proyecto.repository.EdificioRepository;

@Service
public class EdificioServiceImpl implements EdificioService {

	@Autowired
	private EdificioRepository repository;

	@Override
	public List<Edificio> listaEdificio(){
		return repository.findAll();
	}

	@Override
	public Edificio insertaActualizaEdificio(Edificio obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
}
