package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.entidad.Departamento;
import com.proyecto.service.DepartamentoService;

@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {
	
	@Autowired(required = false)
	private DepartamentoService departamentoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento() {
		List<Departamento> lista = departamentoService.listaDepartamento();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaDepartamento(@RequestBody Departamento obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getFec_reg_dep() == null) {
				obj.setFec_reg_dep(new Date());
			}
			Departamento objSalida = departamentoService.insertaActualizaDepartamento(obj);
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
