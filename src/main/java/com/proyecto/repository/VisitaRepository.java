package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer>{
	
	 @Query("SELECT v FROM Visita v WHERE (?1 is '' or v.dni_vis LIKE ?1)")
	 public List<Visita> listaVisitaPorDni(String dni_vis);
	 
	 @Query("SELECT v FROM Visita v WHERE (?1 is '' or v.dni_vis LIKE ?1) "
		 		+ "AND (?2 is '' or v.nom_vis LIKE ?2)")
	 public List<Visita> listaVisitaPorDniNom(String dni_vis, String nom_vis);

}
