package com.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.entidad.Servicio;
import com.proyecto.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {
	
	private ServicioRepository repository; 

	@Override
	public List<Servicio> listaServicio() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
