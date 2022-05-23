package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Visita;
import com.proyecto.entidad.VisitaReg;

public interface VisitaRegRepository extends JpaRepository<VisitaReg, Integer>{

}
