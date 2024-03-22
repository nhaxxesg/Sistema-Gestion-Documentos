package app.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "estudiante")
@PrimaryKeyJoinColumn(referencedColumnName = "usr_codigo", name = "usr_codigo")
public class Estudiante extends Usuario {

	@Column(name = "estd_carrera")
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
			String rol, String telefono, String contrasena, String activo, String carrera, String semestre, List<Proceso> procesos) {
		super(codigo, nombre, apellido1, apellido2, correoInstitucional, rol, telefono, contrasena, activo,procesos);
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
