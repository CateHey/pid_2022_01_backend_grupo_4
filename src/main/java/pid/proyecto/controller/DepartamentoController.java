package pid.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import pid.proyecto.entidad.Departamento;
import pid.proyecto.service.DepartamentoService;
import pid.proyecto.util.AppSettings;

@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins =AppSettings.URL_CROSS_ORIGIN)
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>>listaDepartamento(){
		return ResponseEntity.ok(service.listaDepartamento());
	}
	
	
	//@Autowired
	//private DepartamentoService departamentoService;

	//@GetMapping
	//@ResponseBody
	//public ResponseEntity<List<Departamento>> listaDepartamento() {
	//	return ResponseEntity.ok(departamentoService,listaDepartamento());
		//List<Departamento> lista = departamentoService.listaDepartamento();
		//return ResponseEntity.ok(lista);
	//}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Departamento obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida = service.insertaActualizaDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", pid.proyecto.util.Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
