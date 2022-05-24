package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Visita;
import com.proyecto.entidad.VisitaReg;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitaRegRepository extends JpaRepository<VisitaReg, Integer>{

    @Query("SELECT r FROM visita_reg r JOIN visita v ON v.cod_vis = r.cod_vis " +
            "WHERE (?1 is '' or v.nom_vis LIKE ?1) and (?2 is '' or v.dni_vis LIKE ?2) and r.estado_visreg = ?3")
    public List<VisitaReg> listaVisitaPorNombreDniEstado(String nom_vis, String dni_vis, int estado_visreg);
}
