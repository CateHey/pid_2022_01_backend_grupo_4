package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Boleta;
import com.proyecto.entidad.Incidente_Desc;
import com.proyecto.service.Incidente_DescService;

@RestController
@RequestMapping("/rest/incidentedesc")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidenteDescController {
	
	@Autowired
	private Incidente_DescService IncidenteDescService;

	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Incidente_Desc>> listaIncidenteDesc() {
        List<Incidente_Desc> lst = IncidenteDescService.listaIncidenteDesc();

        return ResponseEntity.ok(lst);
    }

}
