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
	private UsuarioRepositorio usuarioRepositorio;

	public ProcesoRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
		this.usuarioRepositorio = new UsuarioRepositorio();
	}

	public Integer persistirProceso(Proceso proceso, String codigoUsuario) {
		Integer idAsignado = null;
		Usuario usuarioBuscado = usuarioRepositorio.buscarUsuario(codigoUsuario);
		if (!ValidarInformacion.esNulo(proceso) && usuarioBuscado != null) {
			try {
				etx.begin();
				proceso.setUsuario(usuarioBuscado);
				em.persist(proceso);
				etx.commit();
				idAsignado = proceso.getIdProceso();
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				em.close();
				emf.close();
			}
		}
		return idAsignado;
	}

	public Proceso buscaProceso(Integer idProceso){
		return em.find(Proceso.class, idProceso);
	}

}
