package com.proyecto.service;

import java.util.ArrayList;
import java.util.Date;
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
		List<Boleta> lstBoletas1 = new ArrayList<Boleta>();
		lstBoletas1 = repository.listaBoletaPorNombreDniServicioEstado(nom_prop, dni_prop, nom_serv, est_bol);
		
		for (Boleta boleta : lstBoletas1) {
			Integer codBol = boleta.getCod_bol();
			String auxStr = "B" + padLeftZeros(codBol.toString(), 5);			
			boleta.setAuxCodigo(auxStr);
		}
		
		return lstBoletas1;
	}
	
	@Override
	public List<Boleta> listaBoletaPorServicioPropietario(int cod_serv, int cod_prop, int anio) {
		// TODO Auto-generated method stub
		List<Boleta> lstBoletas = new ArrayList<Boleta>();
		lstBoletas = repository.listaBoletaPorServicioPropietario(cod_serv, cod_prop, anio);
		
		for (Boleta boleta : lstBoletas) {
			Integer codBol = boleta.getCod_bol();
			String auxStr = "B" + padLeftZeros(codBol.toString(), 5);			
			boleta.setAuxCodigo(auxStr);
		}
		
		return lstBoletas;
	}

	@Override
	public List<Boleta> obtenerBoletaRegistros(Boleta obj, List<Date> lstFechas) {
		// TODO Auto-generated method stub
		List<Boleta> lstRegistros = new ArrayList<Boleta>(); 
		
		for (int i = 0; i < lstFechas.size(); i++) {
			Date fechaMes = lstFechas.get(i);
			
    		Boleta nuevo = new Boleta();
    		nuevo.setServicio(obj.getServicio());
    		nuevo.setPropietario(obj.getPropietario());
    		nuevo.setAnio(obj.getAnio());
    		nuevo.setEst_bol(obj.getEst_bol());
    		nuevo.setFecha_bol(fechaMes);
    	
    		lstRegistros.add(nuevo);
		}
		
		return lstRegistros;
	}
	
	@Override
	public boolean validarBoletaPendientes(int cod_serv, int cod_prop, int anio) {
		List<Boleta> lst = repository.listaBoletaPorServicioPropietario(cod_serv, cod_prop, anio);
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
