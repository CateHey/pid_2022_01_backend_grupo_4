package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Proveedor;
import com.proyecto.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorRepository repository;
	
	@Override
	public List<Proveedor> listaProveedor(){
		return repository.findAll();
	}

	@Override
	public Proveedor RegistraProveedor(Proveedor obj) {
		return repository.save(obj);
	}


	@Override
	public List<Proveedor> listaProveedorPorRuc(String ruc) {
		return repository.listaProveedorPorRuc(ruc);
	}

}
