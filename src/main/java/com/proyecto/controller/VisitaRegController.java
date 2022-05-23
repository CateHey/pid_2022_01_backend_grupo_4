package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.VisitaReg;
import com.proyecto.service.VisitaRegService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/rest/visitareg")
@CrossOrigin(origins =AppSettings.URL_CROSS_ORIGIN)
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
			obj.setFech_ingr_visreg(new Date());
			obj.setEstado_visreg(0);
			VisitaReg objSalida = visitaregService.insertaActualizaVisitaReg(obj);
			if(objSalida == null) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
