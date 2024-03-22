package app.entidades.repositorios;

import javax.persistence.*;

import app.entidades.Usuario;
import app.entidades.externos.ValidarInformacion;

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
		String idAsignado=null;
		if(!ValidarInformacion.esNulo(usuario) && !existeUsuario(usuario)) {
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

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		if(em.find(Usuario.class, usuario.getCodigo()) != null){
			existe =true;
		}
		return existe;
	}

	public boolean existeUsuario(String codigoUsuario){
		boolean existe = false;
		if(em.find(Usuario.class, codigoUsuario) != null){
			existe =true;
		}
		return existe;
	}

	public Usuario buscarUsuario(String codigo){
		return em.find(Usuario.class, codigo);
	}

	public void persistirUsuarioRefactorizado(Usuario usuario){
		this.etx.begin();
		this.em.persist(usuario);
		this.etx.commit();

	}
}
