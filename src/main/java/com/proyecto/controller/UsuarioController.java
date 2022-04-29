package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.entidad.Usuario;
import com.proyecto.service.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            List<Usuario> objSalida = usuarioService.validarUsuario(obj.getEmail_usu(), obj.getPass_usu());
            if (objSalida.size() == 0) {
                salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_LOGIN_NOVALIDO);
            } else {
            	salida.put("usuario", objSalida.get(0));
                salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_LOGIN_EXITO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", com.proyecto.util.Constantes.MENSAJE_LOGIN_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

}
