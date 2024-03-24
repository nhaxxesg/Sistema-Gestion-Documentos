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
	@JoinColumn(name = "usr_codigo", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "proceso", cascade = CascadeType.ALL)
	private List<Documento> documentos;

	public Proceso() {
		super();
	}

	public Proceso(String nombre, Date fechaInicio, Date fechaFinalizacion, String estado, Usuario usuario,
			List<Documento> documentos) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.estado = estado;
		this.usuario = usuario;
		this.documentos = documentos;
	}

	

	public Proceso(String nombre, Date fechaInicio, Date fechaFinalizacion, String estado,
			List<Documento> documentos) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.estado = estado;
		this.documentos = documentos;
	}

	public Integer getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

}
