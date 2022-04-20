package com.proyecto.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ComprobanteHasProductoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idComprobante;
	private int idProducto;

}
