package com.proyecto.service;

import com.proyecto.entidad.Propietario;

import java.util.List;

public interface PropietarioService {

    public abstract List<Propietario> lstPropiertario();
    public abstract Propietario insertaActualizaPropietario(Propietario obj);

}
