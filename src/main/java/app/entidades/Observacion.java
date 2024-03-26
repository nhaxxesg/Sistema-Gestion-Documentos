package app.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "observacion")
public class Observacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "obs_id")
	private Integer idObservacion;
	@Column(name = "obs_contenido")
	private String contenido;
	@Column(name = "obs_fecha")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "doc_id")
	private Documento documento;

	@ManyToOne
	@JoinColumn(name = "usr_codigo")
	private Empleado empleado; 
	
	public Observacion() {
		super();
	}

	public Observacion(String contenido, Date fecha, Empleado empleado) {
		super();
		this.contenido = contenido;
		this.fecha = fecha;
		this.empleado = empleado;
	}

	
	public Observacion(String contenido, Date fecha, Documento documento) {
		this.contenido = contenido;
		this.fecha = fecha;
		this.documento = documento;
	}

	

	public Observacion(String contenido, Date fecha) {
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public Integer getIdObservacion() {
		return idObservacion;
	}

	public void setIdObservacion(Integer idObservacion) {
		this.idObservacion = idObservacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Observacion [idObservacion=" + idObservacion + ", contenido=" + contenido + ", fecha=" + fecha
				+ ", documento=" + documento.getTitulo() + ", empleado=" + empleado.getNombre() + "]";
	}
	
	
	
}
