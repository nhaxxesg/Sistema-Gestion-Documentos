package app.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "informe")
public class Informe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInforme;
	private String titulo;
	private String tema;
	private Date fechaCreacion; 
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "usr_codigo")
	private Empleado empleado;
	
}
