package app.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado extends Usuario{
	@Id
	@OneToOne
	@JoinColumn(name = "usr_codigo")
	private Usuario usuario;
	
	@Column(name = "emp_area")
	private String area;
	
	@OneToMany(mappedBy = "empleado")
	private List<Informe> informes;
	
	
	
}
