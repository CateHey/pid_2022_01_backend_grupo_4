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
            " WHERE (?1 is '' or e.nom_edi LIKE ?1) and (?2 is '' or d.num_dep LIKE ?2) and (?3 is -1 or i.estado_inc = ?3) "
            + "and (?4 is '' or x.nom_incd = ?4)" )
    public List<Incidente> listaIncidentePorEdificioDepartamentoEstado(String nom_edi, String num_dep, int estado_inc, String nom_incd );
	
	@Query("SELECT i FROM Incidente i JOIN Edificio e ON i.edificio = e.cod_edi JOIN Departamento d ON i.departamento = d.cod_dep "
			+ "JOIN Incidente_Desc x ON x.cod_incd = i.incidente_desc " +
            "WHERE (?1 is '' or e.nom_edi LIKE ?1) and (?2 is '' or d.num_dep LIKE ?2) "
            + "and (?3 is '' or x.nom_incd = ?3) and i.estado_inc = 0" )
    public List<Incidente> listaParaValidar(String nom_edi, String num_dep, String nom_incd );
    

}
