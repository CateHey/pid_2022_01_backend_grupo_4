package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Incidente;
import com.proyecto.entidad.VisitaReg;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	
	@Query()
    public List<VisitaReg> listaIncidentePorEdificioDepartamentoEstado(int cod_edi, int cod_dep, int estado_inc);
    
    @Query()
    public List<VisitaReg> listaIncidentePorIncidenteDesc(int cod_incd);

}
