package app.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "usr_rol", discriminatorType = DiscriminatorType.STRING)
public class Usuario {
	@Id
	@Column(name = "usr_codigo")
	private String codigo;
	@Column(name = "usr_nombre")
	private String nombre;
	@Column(name = "usr_apellido1")
	private String apellido1;
	@Column(name = "usr_apellido2")
	private String apellido2;
	@Column(name = "usr_correo_institucional")
	private String correoInstitucional;
	@Column(name = "usr_rol")
	private String rol;
	@Column(name = "usr_telefono")
	private String telefono;
	@Column(name = "usr_contrasena")
	private String contrasena;
	@Column(name = "usr_activo")
	private String activo;
	
	
	/*@OneToMany(mappedBy = "usuario")
	private List<Notificacion> notificaciones;
	@OneToMany(mappedBy = "usuario")
	private List<Proceso> procesos;
	*/
	@OneToMany(mappedBy = "usuario")
	private List<Proceso> procesos;
	
	public Usuario() {
		super();
	}

	public Usuario(String codigo, String nombre, String apellido1, String apellido2, String correoInstitucional,
			String rol, String telefono, String contrasena, String activo, List<Proceso> procesos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correoInstitucional = correoInstitucional;
		this.rol = rol;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.activo = activo;
		this.procesos = procesos;
		
	}
	

	// Getters y Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCorreoInstitucional() {
		return correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	// Método toString()
	@Override
	public String toString() {
		return "Usuario{" + "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + ", apellido1='" + apellido1
				+ '\'' + ", apellido2='" + apellido2 + '\'' + ", correoInstitucional='" + correoInstitucional + '\''
				+ ", rol='" + rol + '\'' + ", telefono='" + telefono + '\'' + ", contrasena='" + contrasena + '\''
				+ ", activo='" + activo + '\'' + '}';
	}
}
