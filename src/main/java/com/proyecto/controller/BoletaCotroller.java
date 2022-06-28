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
import com.proyecto.service.BoletaService;

@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaCotroller {
	
	@Autowired
	private BoletaService boletaService;
	
	
	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Boleta>> listaBoleta() {
        List<Boleta> lst = boletaService.listaBoleta();

        return ResponseEntity.ok(lst);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaBoleta(@RequestBody Boleta obj) {
        Map<String, Object> salida = new HashMap<String,Object>();
        try {
        	int anho = obj.getAnio();
    		List<Date> listaFechas = new ArrayList<Date>();  
    		listaFechas = (ArrayList<Date>) com.proyecto.util.GenerarFechas.listaFechaPago(anho);
    		
    		//Validar que no exista boletas pendientes de pago
    		boolean validar = boletaService.validarBoletaPendientes(obj.getServicio().getCod_serv(), 
    				obj.getPropietario().getCod_prop(), obj.getAnio());
			if (validar) {
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_BOLETA_PENDIENTES);
				salida.put("mostrar", "NO");
			} else {
				List<Boleta> lstBoletas = new ArrayList<Boleta>(); 
	    		lstBoletas = boletaService.obtenerBoletaRegistros(obj, listaFechas);
	    		
	    		for (Boleta boleta : lstBoletas) {
	    			Boleta objSalida = boletaService.insertaActualizaBoleta(boleta);    
	        		if (objSalida == null) {
	                    salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
	                    salida.put("mostrar", "NO");
	                } else {
	                    salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
	                    salida.put("mostrar", "SI");
	                }
				}
			}

        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
            salida.put("mostrar", "NO");
        }
        return ResponseEntity.ok(salida);
    }
    
    @GetMapping("/listaBoletaConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaBoletaPorNombreDniServicioEstado(

			@RequestParam(name = "nombre", required = false, defaultValue = "") String nom_prop,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni_prop,
			@RequestParam(name = "servicio", required = false, defaultValue = "") String nom_serv,
			@RequestParam(name = "estado", required = false, defaultValue = "-1") int est_bol
	) {
		Map<String, Object> salida = new HashMap<>();
		//String nom_prop, String dni_prop, String nom_serv, int est_bol
		try {
			List<Boleta> lista = boletaService.listaBoletaPorNombreDniServicioEstado("%"+nom_prop+"%", dni_prop,nom_serv, est_bol);
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
    
    @PutMapping("/actualizaBoleta")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaBoleta(@RequestBody Boleta obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_bol() == 0) {
				salida.put("mensaje", "El ID de la boleta debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Boleta objSalida = boletaService.insertaActualizaBoleta(obj);
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
    
    @GetMapping("/listaBoletaRegistradas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaBoletaRegistradas(
			@RequestParam(name = "servicio", required = false, defaultValue = "-1") int cod_serv,
			@RequestParam(name = "propietario", required = false, defaultValue = "-1") int cod_prop,
			@RequestParam(name = "anio", required = false, defaultValue = "0000") int anio_bol
	) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Boleta> lista = boletaService.listaBoletaPorServicioPropietario(cod_serv, cod_prop, anio_bol);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
