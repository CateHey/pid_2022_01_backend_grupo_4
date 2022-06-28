package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Incidente_Desc;
import com.proyecto.repository.Incidente_DescRepository;

@Service
public class Incidente_DescServiceImpl implements Incidente_DescService{
	
	@Autowired
	private Incidente_DescRepository repository;

	@Override
	public List<Incidente_Desc> listaIncidenteDesc() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
