package pid.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pid.proyecto.entidad.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
