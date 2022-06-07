package com.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.entidad.Boleta;
import com.proyecto.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{
	
	private BoletaRepository repository;

	@Override
	public List<Boleta> listaBoleta() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
	

}
