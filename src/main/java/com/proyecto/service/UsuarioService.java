package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Opcion;
import com.proyecto.entidad.Rol;
import com.proyecto.entidad.Usuario;

public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
}
