package app.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	
	
}
