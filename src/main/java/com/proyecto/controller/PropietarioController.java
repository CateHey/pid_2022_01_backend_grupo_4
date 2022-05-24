package com.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entidad.Departamento;
import com.proyecto.entidad.Propietario;
import com.proyecto.service.PropietarioService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/propietario")
@CrossOrigin(origins = "http://localhost:4200")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Propietario>> listaPropietario() {
        List<Propietario> lst = propietarioService.lstPropiertario();

        return ResponseEntity.ok(lst);
    }

    
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaPropietario(@RequestBody Propietario obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
        	if (obj.getFech_reg_prop() == null) {
				obj.setFech_reg_prop(new Date());
			}
            Propietario objSalida = propietarioService.insertaActualizaPropietario(obj);
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
