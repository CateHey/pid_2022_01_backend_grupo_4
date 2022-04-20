package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
