package pid.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pid.proyecto.entidad.Mascota;


public interface MascotaService {
	public abstract List<Mascota> listaMascota();
	public abstract Mascota insertaActualizaMascota(Mascota obj);
}
