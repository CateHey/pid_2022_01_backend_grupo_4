package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Incidente;
import com.proyecto.entidad.VisitaReg;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	
	@Query("SELECT i FROM Incidente i JOIN Edificio e ON i.edificio = e.cod_edi "
			+ "JOIN Departamento d ON i.departamento = d.cod_dep "
			+ "JOIN Incidente_Desc x ON x.cod_incd = i.incidente_desc" +
            " WHERE (?1 is -1 or e.cod_edi = ?1) and (?2 is -1 or d.cod_dep = ?2) and (?3 is -1 or i.estado_inc = ?3) "
            + "and (?4 is -1 or x.cod_incd = ?4)" )
    public List<Incidente> listaIncidentePorEdificioDepartamentoEstado(int cod_edi, int cod_dep, int estado_inc, int cod_incd);
	
	@Query("SELECT i FROM Incidente i JOIN Edificio e ON i.edificio = e.cod_edi JOIN Departamento d ON i.departamento = d.cod_dep "
			+ "JOIN Incidente_Desc x ON x.cod_incd = i.incidente_desc " +
            "WHERE (?1 is -1 or e.cod_edi = ?1) and (?2 is -1 or d.cod_dep = ?2) "
            + "and (?3 is -1 or x.cod_incd = ?3) and i.estado_inc = 1" )
    public List<Incidente> listaParaValidar(int cod_edi, int cod_dep, int cod_incd);
    
}
