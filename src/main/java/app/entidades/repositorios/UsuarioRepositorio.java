package app.entidades.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.entidades.Usuario;

public class UsuarioRepositorio {
	private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

	public UsuarioRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
	}

	public String persistirUsuario(Usuario usuario) {
		//boolean esValido=validar(usuario);
		boolean esValido =true;
		String idAsignado=null;
		if(esValido) {
			try {
				etx.begin();
				em.persist(usuario);
				etx.commit();
				idAsignado= usuario.getCodigo();
			} catch (Exception e) {
				etx.rollback();
			}
		}
		return idAsignado;
	}

	private boolean validar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
