package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{
	
	@Query("SELECT b FROM Boleta b JOIN Propietario p ON p.cod_prop = b.propietario "
			+ "JOIN Servicio s ON s.cod_serv = b.servicio " +
			"WHERE (?1 is '' or p.nom_prop LIKE ?1) and (?2 is '' or p.dni_prop LIKE ?2) and (?3 is '' or s.nom_serv = ?3) "
			+ "and (?4 is -1 or b.est_bol= ?4)")
    public List<Boleta> listaBoletaPorNombreDniServicioEstado(String nom_prop, String dni_prop, String nom_serv, int est_bol);
	
	@Query("SELECT b FROM Boleta b JOIN Propietario p ON p.cod_prop = b.propietario "
			+ "JOIN Servicio s ON s.cod_serv = b.servicio " +
			"WHERE s.cod_serv is ?1 and p.cod_prop is ?2 "
			+ "and YEAR(b.fecha_bol) = ?3 and b.est_bol = 0")
    public List<Boleta> listaBoletaPorServicioPropietario(int cod_serv, int cod_prop, int anio);
	
}
