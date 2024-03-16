package app.entidades.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.entidades.Proceso;
import app.entidades.Usuario;
import app.entidades.externos.ValidarInformacion;

public class ProcesoRepositorio {
	private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

	public ProcesoRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
	}

	public Integer crearProceso(Proceso proceso, String codigoUsuario) {
		// boolean esValido = ValidarInformacion.validar(proceso);
		boolean esValido = true;
		Integer idAsignado = null;
		if (esValido) {
			Usuario usuarioBuscado = buscarUsuarioPorCodigo(codigoUsuario);
			try {
				etx.begin();
				proceso.setUsuario(usuarioBuscado);
				em.persist(proceso);
				etx.commit();
				idAsignado = proceso.getIdProceso();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return idAsignado;
	}

	public Usuario buscarUsuarioPorCodigo(String codigoUsuario) {
		return em.find(Usuario.class, codigoUsuario);
	}
}
