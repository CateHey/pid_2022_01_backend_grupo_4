package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Boleta;
import com.proyecto.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{
	
	@Autowired
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

	@Override
	public List<Boleta> listaBoletaPorNombreDniServicioEstado(String nom_prop, String dni_prop, String nom_serv,
			int est_bol) {
		// TODO Auto-generated method stub
		return repository.listaBoletaPorNombreDniServicioEstado(nom_prop, dni_prop, nom_serv, est_bol);
	}
	
	

}
