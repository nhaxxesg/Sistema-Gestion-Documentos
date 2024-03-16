package app.servicio;

import javax.persistence.*;

import app.entidades.Documento;
import app.entidades.Empleado;
import app.entidades.Estudiante;
import app.entidades.Observacion;
import app.entidades.Proceso;
import app.entidades.Usuario;

public class UsuarioServicio {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Integer idProceso;
	private Integer idDocumento;
	private String idUsuario;
	
	
	public UsuarioServicio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public void crearUsuario(Usuario usuario) {
		this.em = emf.createEntityManager();
		EntityTransaction etx=em.getTransaction();
		try {
			etx.begin();
			if(usuario != null) {
				//si se tiene que persistir los informes generados por cada empleado
				em.persist(usuario);
				
			}else {
				System.out.println("el usuario ingresado es nulo");
			}
			etx.commit();
			this.idUsuario = usuario.getCodigo();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	
	public void crearProceso(Proceso proceso) {
		this.em = emf.createEntityManager();
		EntityTransaction etx=em.getTransaction();
		try {
			etx.begin();
			em.persist(proceso);
			etx.commit();
			idProceso = proceso.getIdProceso();
			
			
		} catch (Exception e) {
			etx.rollback();
		}
	}
		
	public void crearDocumento(Documento documento) {
		this.em = emf.createEntityManager();
		EntityTransaction etx=em.getTransaction();
		try {
			etx.begin();
			Proceso procesoEncontrado = em.find(Proceso.class, idProceso);
			documento.setProceso(procesoEncontrado);
			em.persist(documento);
			etx.commit();
			this.idDocumento = documento.getIdDocumento();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void crearObservacion(Observacion observacion) {
		this.em = emf.createEntityManager();
		EntityTransaction etx=em.getTransaction();
		try {
			etx.begin();
			Documento procesoEncontrado = em.find(Documento.class, idDocumento);
			observacion.setDocumento(procesoEncontrado);
			//Usuario usuarioEncontrado = em.find(Usuario.class, idUsuario);
			em.persist(observacion);
			etx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

	
	
