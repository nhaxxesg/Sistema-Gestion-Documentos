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
@Table(name = "notificacion")
public class Notificacion {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notf_id")
	private Integer id;
	@Column(name = "notf_titulo")
	private String titulo; 
	@Column(name = "notf_correo_destino")
	private String correDestino;
	@Column(name = "notf_fecha_envio")
	private Date fechaEnvio;
	
	@ManyToOne
	@JoinColumn(name = "usr_codigo")
	private Usuario usuario;
	
}
