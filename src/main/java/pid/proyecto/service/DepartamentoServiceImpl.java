package pid.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pid.proyecto.entidad.Departamento;
import pid.proyecto.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoRepository repository;

	@Override
	public List<Departamento> listaDepartamento() {
		return repository.findAll();
	}

	@Override
	public Departamento insertaActualizaDepartamento(Departamento obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	

}
