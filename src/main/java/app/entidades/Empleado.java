package app.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "usr_codigo", referencedColumnName = "usr_codigo")
public class Empleado extends Usuario {

	@Column(name = "emp_area")
	private String area;

	@OneToMany(mappedBy = "empleado")
	private List<Informe> informes;
	
	@OneToMany(mappedBy = "empleado")
	private List<Observacion> observacionesRealizadas;

	public Empleado() {
		super();
	}

	public Empleado(String area, List<Informe> informes) {
		super();
		this.area = area;
		this.informes = informes;
	}

	public Empleado(String codigo, String nombre, String apellido1, String apellido2, String correoInstitucional,
			String rol, String telefono, String contrasena, String activo, String area, List<Informe> informes, List<Proceso> procesos) {
		super(codigo, nombre, apellido1, apellido2, correoInstitucional, rol, telefono, contrasena, activo, procesos);
		this.area = area;
		this.informes = informes;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Informe> getInformes() {
		return informes;
	}

	public void setInformes(List<Informe> informes) {
		this.informes = informes;
	}

	

}
