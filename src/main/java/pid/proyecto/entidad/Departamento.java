package pid.proyecto.entidad;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyecto.entidad.Ubigeo;

public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_dep;
	
	private int metros_dep;
	
	private String tel_dep;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_edi")
	private Edificio edificio;
	
	private double pre_dep;

	

	
}
