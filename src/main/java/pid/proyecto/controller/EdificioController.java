package pid.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pid.proyecto.entidad.Edificio;
import pid.proyecto.service.EdificioService;
import pid.proyecto.util.AppSettings;

@RestController
@RequestMapping("/rest/edificio")
@CrossOrigin(origins =AppSettings.URL_CROSS_ORIGIN)

public class EdificioController {
	private EdificioService edifcioService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Edificio>> listaEdificio() {
		List<Edificio> lista = edifcioService.listaEdificio();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Edificio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Edificio objSalida = edifcioService.insertaActualizaEdificio(obj);
			if (objSalida == null) {
				salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
