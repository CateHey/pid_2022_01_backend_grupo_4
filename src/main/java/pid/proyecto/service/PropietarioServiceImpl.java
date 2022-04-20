package pid.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import pid.proyecto.entidad.Propietario;
import pid.proyecto.repository.PropietarioRepository;

import java.util.List;

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
