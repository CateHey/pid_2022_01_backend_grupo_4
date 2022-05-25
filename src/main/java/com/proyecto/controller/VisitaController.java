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

import com.proyecto.entidad.Visita;
import com.proyecto.entidad.VisitaReg;
import com.proyecto.service.VisitaService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/rest/visita")
@CrossOrigin(origins =AppSettings.URL_CROSS_ORIGIN)
public class VisitaController {
	
	@Autowired
	private VisitaService visitaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visita>> listaVisita(){
		List<Visita> lst = visitaService.listaVisita();
		return ResponseEntity.ok(lst);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVisita(@RequestBody Visita obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFech_vis(new Date());
			Visita objSalida = visitaService.insertaActualizaVisita(obj);
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
	
	@GetMapping("/listaVisitaPorDni")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaVisitaPorDNI(
	@RequestParam(name = "dni_vis", required = false, defaultValue = "") String dni_vis	) 
	{
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visita> lista = visitaService.listaVisitaPorDni(dni_vis);
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
	
	@GetMapping("/listaVisitaPorDniNom")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaVisitaPorDniNom(
	@RequestParam(name = "dni_vis", required = false, defaultValue = "") String dni_vis, 
	@RequestParam(name = "nom_vis", required = false, defaultValue = "") String nom_vis ) 
	{
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visita> lista = visitaService.listaVisitaPorDniNom(dni_vis, nom_vis);
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

}
