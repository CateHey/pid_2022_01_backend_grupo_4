package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Propietario;
import com.proyecto.repository.PropietarioRepository;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    private PropietarioRepository repository;

    @Override
    public List<Propietario> lstPropiertario() {
        return repository.findAll();
    }

    @Override
    public Propietario insertaActualizaPropietario(Propietario obj) {
        return repository.save(obj);
    }
}
