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
@Table(name = "pedido_has_producto")
public class PedidoHasProducto {

	@EmbeddedId
	private PedidoHasProductoPK pedidoHasProductoPK;
	private double precio;
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "idPedido", nullable = false, insertable = false, updatable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

	

}
