package pid.proyecto.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROPIETARIO")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_prop;
    private String nom_prop;
    private String ape_prop;
    private String dni_prop;
    private String tel_prop;
    private String email_prop;
    private int cod_usu;
    private int cod_dep;
    private String fech_prop;
    private String hora_prop;

}
