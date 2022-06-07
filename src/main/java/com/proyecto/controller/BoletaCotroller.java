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

import com.proyecto.entidad.Boleta;
import com.proyecto.entidad.Mascota;
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
        	if (obj.getFecha_bol() == null) {
				obj.setFecha_bol(new Date());
			}
        	Boleta objSalida = boletaService.insertaActualizaBoleta(obj);
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
