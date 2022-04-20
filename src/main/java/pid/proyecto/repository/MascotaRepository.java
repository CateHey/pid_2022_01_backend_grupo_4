package pid.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pid.proyecto.entidad.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
