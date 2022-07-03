package com.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Incidente;
import com.proyecto.repository.IncidenteRepository;

@Service
public class IncidenteServiceImpl implements IncidenteService{
	
	@Autowired
	private IncidenteRepository repository;

	@Override
	public List<Incidente> listaIncidentes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Incidente insertaActualizaIncidentes(Incidente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaIncidentePorEdiDepEstCau(int cod_edi, int cod_dep, int estado_inc, int cod_incd) {
		// TODO Auto-generated method stub
		List<Incidente> lstIncidentes = new ArrayList<Incidente>();
		lstIncidentes = repository.listaIncidentePorEdificioDepartamentoEstado(cod_edi, cod_dep, estado_inc, cod_incd);
		
		for (Incidente reg : lstIncidentes) {
			Integer codReg = reg.getCod_inc();
			String auxStr = padLeftZeros(codReg.toString(), 5);			
			reg.setAuxCodigo(auxStr);
		}
		
		return lstIncidentes;
	}

	@Override
	public boolean validarIncidentesPendientes(int cod_edi, int cod_dep , int cod_incd) {
		// TODO Auto-generated method stub
		List<Incidente> lst = repository.listaParaValidar(cod_edi, cod_dep, cod_incd);
		return lst.size() > 0 ? true : false;
	}
	
	private String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}

}
