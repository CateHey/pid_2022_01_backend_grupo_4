package com.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.proyecto.entidad.Boleta;
import com.proyecto.entidad.Mascota;
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

}
