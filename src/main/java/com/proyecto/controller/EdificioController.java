package com.proyecto.controller;

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

import com.proyecto.entidad.Edificio;
import com.proyecto.service.EdificioService;

@RestController
@RequestMapping("/rest/edificio")
@CrossOrigin(origins = "http://localhost:4200")
public class EdificioController {
	
	@Autowired
	private EdificioService edifcioService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Edificio>> listaEdificio() {
		List<Edificio> lista = edifcioService.listaEdificio();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEdificio(@RequestBody Edificio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Edificio objSalida = edifcioService.insertaActualizaEdificio(obj);
			if (objSalida == null) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
