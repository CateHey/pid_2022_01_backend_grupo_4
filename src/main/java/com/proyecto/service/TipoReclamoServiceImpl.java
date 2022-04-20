package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.TipoReclamo;
import com.proyecto.repository.TipoReclamoRepository;


@Service

public class TipoReclamoServiceImpl implements TipoReclamoService {

	@Autowired
	private TipoReclamoRepository Repository;

	@Override
	public List<TipoReclamo> listaTipoReclamo() {
		return Repository.findAll();
	}

}
