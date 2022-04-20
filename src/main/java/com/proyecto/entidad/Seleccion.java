package com.proyecto.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seleccion {
	
	private int idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	private double totalParcial;
	
	public double getTotalParcial() {
		totalParcial = precio * cantidad;
		return totalParcial;
	}

	
}
