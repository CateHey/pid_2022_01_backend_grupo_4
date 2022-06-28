package com.proyecto.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Boleta;
import com.proyecto.entidad.Incidente;
import com.proyecto.service.BoletaService;
import com.proyecto.service.IncidenteService;

@RestController
@RequestMapping("/rest/incidente")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidenteController {
	
	@Autowired
	private IncidenteService incidenteService;
	
	
	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Incidente>> listaIncidentes() {
        List<Incidente> lst = incidenteService.listaIncidentes();

        return ResponseEntity.ok(lst);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaIncidente(@RequestBody Incidente obj) {
        Map<String, Object> salida = new HashMap<String,Object>();
        try {
    		boolean validar = incidenteService.validarIncidentesPendientes(obj.getEdificio().getNom_edi(),obj.getDepartamento().getNum_dep(),
    				obj.getIncidente_desc().getNom_incd());
			if (validar) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_BOLETA_PENDIENTES);
				salida.put("mostrar", "NO");
			} else {
					obj.setEstado_inc(1);
	    			Incidente objSalida = incidenteService.insertaActualizaIncidentes(obj);    
	    			if(objSalida == null) {
						salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
					}else {
						salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
					}
	    			
				
			}

        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
            salida.put("mostrar", "NO");
        }
        return ResponseEntity.ok(salida);
    }
    
    @GetMapping("/listaIncidenteConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaIncidentePorEdificioDepartamentoEstado(

			@RequestParam(name = "nom_edi", required = false, defaultValue = "") String nom_edi,
			@RequestParam(name = "num_dep", required = false, defaultValue = "") String num_dep,
			@RequestParam(name = "estado_inc", required = false, defaultValue = "-1") int estado_inc,
			@RequestParam(name = "nom_incd", required = false, defaultValue = "") String nom_incd
	) {
		Map<String, Object> salida = new HashMap<>();
		//String nom_prop, String dni_prop, String nom_serv, int est_bol
		try {
			List<Incidente> lista = incidenteService.listaBoletaPorEdiDepEstCau(nom_edi, num_dep,estado_inc, nom_incd);
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
    
    @PutMapping("/actualizaIncidente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaIncidente(@RequestBody Incidente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_inc() == 0) {
				salida.put("mensaje", "El ID del incidente debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Incidente objSalida = incidenteService.insertaActualizaIncidentes(obj);
			if(objSalida == null) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_BOLETA_PAGADA);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
    

}
