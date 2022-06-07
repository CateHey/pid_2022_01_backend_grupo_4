package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Servicio;
import com.proyecto.service.ServicioService;

@RestController
@RequestMapping("/rest/servicio")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Servicio>> listaServicio() {
        List<Servicio> lst = servicioService.listaServicio();

        return ResponseEntity.ok(lst);
    }

}
