package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	
	@Query(value = "Select * from proveedor e where e.ruc = ?1", nativeQuery = true)
	public abstract List<Proveedor> listaProveedorPorRuc(String ruc);

	

	
}
