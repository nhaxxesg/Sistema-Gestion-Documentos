package app.entidades.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.entidades.Documento;
import app.entidades.Proceso;

public class DocumentoRepositorio {
	private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

	public DocumentoRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
	}

	public Integer crearDocumento(Documento documento, Integer idProceso) {
		Integer idAsignado = null;
		
		try {
			etx.begin();
			Proceso procesoEncontrado = em.find(Proceso.class, idProceso);
			documento.setProceso(procesoEncontrado);
			em.persist(documento);
			etx.commit();
			idAsignado = documento.getIdDocumento();
		} catch (Exception e) {
			etx.rollback();
		}
		return idAsignado;
	}
}
