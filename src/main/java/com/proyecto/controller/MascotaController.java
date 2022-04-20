package com.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entidad.Mascota;
import com.proyecto.service.MascotaService;
import com.proyecto.util.AppSettings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/mascota")
@CrossOrigin(origins =AppSettings.URL_CROSS_ORIGIN)

public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Mascota>> listaMascota() {
        List<Mascota> lst = mascotaService.listaMascota();

        return ResponseEntity.ok(lst);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaMascota(@RequestBody Mascota obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Mascota objSalida = mascotaService.insertaActualizaMascota(obj);
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
