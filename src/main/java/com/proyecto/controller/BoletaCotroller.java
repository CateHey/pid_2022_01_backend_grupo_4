package com.proyecto.controller;

import java.text.SimpleDateFormat;
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
import com.proyecto.entidad.Mascota;
import com.proyecto.entidad.VisitaReg;
import com.proyecto.service.BoletaService;
import com.proyecto.util.GenerarFechas;

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
        	int anho=obj.getAnio();
    		ArrayList<Date> listaFechas = new ArrayList<Date>() ;  
    		listaFechas = (ArrayList<Date>) com.proyecto.util.GenerarFechas.listaFechaPago(anho);
        	for (int i = 0; i < 12; i++) {      		
        		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");        		
        		obj.setFecha_bol(listaFechas.get(i));
        		Boleta objSalida = boletaService.insertaActualizaBoleta(obj);    
        		if (objSalida == null) {
                    salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
                } else {
                    salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
                }
    		}
        	
        	/*if (obj.getFecha_bol() == null) {
				obj.setFecha_bol(new Date());
			}*/
        	
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_ERROR);
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
				salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
