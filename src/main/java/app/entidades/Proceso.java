package app.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "proceso")
public class Proceso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proc_id")
	private Integer idProceso;
	@Column(name = "proc_nombre")
	private String nombre;
	@Column(name = "proc_fecha_inicio")
	private Date fechaInicio;
	@Column(name = "proc_fecha_finalizacion")
	private Date fechaFinalizacion;
	@Column(name = "proc_estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "usr_codigo") 
	private Usuario usuario;
	
	@OneToMany(mappedBy = "proceso")
	private List<Documento> documentos;
	
	
	
	
}
