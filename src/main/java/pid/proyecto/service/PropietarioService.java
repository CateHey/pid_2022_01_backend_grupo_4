package pid.proyecto.service;

import pid.proyecto.entidad.Propietario;

import java.util.List;

import org.springframework.stereotype.Service;



public interface PropietarioService {

    public abstract List<Propietario> lstPropiertario();
    public abstract Propietario insertaActualizaPropietario(Propietario obj);

}
