package app.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private Integer idDocumento;
	@Column(name = "doc_titulo")
	private String titulo;
	@Column(name = "doc_fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "doc_fecha_modificacion")
	private Date fechaModificacion;
	@Column(name = "doc_fecha_emision")
	private Date fechaEmision;
	@Column(name = "doc_estado")
	private String estado;
	@Column(name = "doc_formato")
	private String formato;
	
	@ManyToOne
	@JoinColumn(name = "proc_id")
	private Proceso proceso;
	
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
	private List<Observacion> observaciones;

	public Documento() {
		super();
	}
	


	public Documento(Integer idDocumento, String titulo, Date fechaCreacion, Date fechaModificacion, Date fechaEmision,
			String estado, String formato) {
		this.idDocumento = idDocumento;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.formato = formato;
	}



	public Documento(String titulo, Date fechaCreacion, Date fechaModificacion, Date fechaEmision, String estado,
			String formato, Proceso proceso) {
		super();
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.formato = formato;
		this.proceso = proceso;
	}

	

	public Documento(String titulo, Date fechaCreacion, Date fechaModificacion, Date fechaEmision,
			String estado, String formato) {
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.formato = formato;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public List<Observacion> getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(List<Observacion> observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + idDocumento + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", fechaEmision=" + fechaEmision + ", estado=" + estado
				+ ", formato=" + formato + ", proceso=" + proceso + ", observaciones=" + observaciones + "]";
	}

	

	
}
