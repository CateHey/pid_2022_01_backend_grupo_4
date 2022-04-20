package pid.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pid.proyecto.entidad.Edificio;
import pid.proyecto.repository.EdificioRepository;

public class EdificioServiceImpl implements EdificioService {

	@Autowired
	private EdificioRepository repository;

	@Override
	public List<Edificio> listaEdificio(){
		return repository.findAll();
	}

	@Override
	public Edificio insertaActualizaEdificio(Edificio obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
}
