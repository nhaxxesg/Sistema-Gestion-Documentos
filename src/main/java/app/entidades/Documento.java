package app.entidades;

import java.util.Date;
import java.util.List;

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
	private String idDocumento;
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
	
	@OneToMany(mappedBy = "documento")
	private List<Observacion> observaciones;

}
