package com.proyecto.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comprobante_has_producto")
public class ComprobanteHasProducto {

	@EmbeddedId
	private ComprobanteHasProductoPK comprobanteHasProductoPK;

	@ManyToOne
	@JoinColumn(name = "idComprobante", nullable = false, insertable = false, updatable = false)
	private Comprobante comprobante;

	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

	private double precio;
	private int cantidad;

}
