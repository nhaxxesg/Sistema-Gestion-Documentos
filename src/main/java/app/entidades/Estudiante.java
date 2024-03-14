package app.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante extends Usuario {
	// regla de negocio: puedo crear un estudiante que no este asociado
	@OneToOne()
	@JoinColumn(name ="usr_codigo")
	private Usuario usuario;
	@Column(name = "est_carrera")
	private String carrera;
	@Column(name = "estd_semestre")
	private String semestre;
	

	public Estudiante() {
		super();
	}

	public Estudiante(String carrera, String semestre) {
		super();
		this.carrera = carrera;
		this.semestre = semestre;
	}

	public Estudiante(String codigo, String nombre, String apellido1, String apellido2, String correoInstitucional,
			String rol, String telefono, String contrasena, String activo, String carrera, String semestre) {
		super(codigo, nombre, apellido1, apellido2, correoInstitucional, rol, telefono, contrasena, activo);
		this.carrera = carrera;
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Estudiante [carrera=");
		builder.append(carrera);
		builder.append(", semestre=");
		builder.append(semestre);
		builder.append("]");
		return builder.toString();
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	
}
