package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.proyecto.entidad.VisitaReg;
import com.proyecto.service.VisitaRegService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/rest/visitareg")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class VisitaRegController {

	@Autowired
	private VisitaRegService visitaregService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<VisitaReg>> listaVisita(){
		List<VisitaReg> lst = visitaregService.listaVisitaReg();
		return ResponseEntity.ok(lst);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVisitaReg(@RequestBody VisitaReg obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			//Validar que no exista duplicado del visitante ingresado
			boolean validar = visitaregService.validarVisitanteActivo(obj.getVisita().getCod_vis());
			if (validar) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_VISITA_DUPLICADO);
			} else {
				obj.setEstado_visreg(1);
				VisitaReg objSalida = visitaregService.insertaActualizaVisitaReg(obj);
				if(objSalida == null) {
					salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
				}else {
					salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}


	@GetMapping("/listaVisitaConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaVisitaPorDNINombreEstado(

			@RequestParam(name = "nombre", required = false, defaultValue = "") String nom_vis,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni_vis,
			@RequestParam(name = "estado", required = false, defaultValue = "-1") int estado_visreg
	) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<VisitaReg> lista = visitaregService.listaVisitaPorNombreDniEstado("%"+nom_vis+"%", dni_vis, estado_visreg);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaVisita")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaVisitaReg(@RequestBody VisitaReg obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_visreg() == 0) {
				salida.put("mensaje", "El ID de la visita debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			VisitaReg objSalida = visitaregService.insertaActualizaVisitaReg(obj);
			if(objSalida == null) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
