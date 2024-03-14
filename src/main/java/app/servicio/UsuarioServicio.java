package app.servicio;

import javax.persistence.*;

import app.entidades.Usuario;

public class UsuarioServicio {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UsuarioServicio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public void crearUsuario(Usuario usuario) {
		this.em = emf.createEntityManager();
		em.persist(usuario);
		
	}
	
	
	
}
