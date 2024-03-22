package app.entidades.repositorios;

import javax.persistence.*;

import app.entidades.*;
import app.entidades.externos.ValidarInformacion;

public class DocumentoRepositorio {
	private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;
	private ProcesoRepositorio procesoRepositorio;

	public DocumentoRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
		this.procesoRepositorio = new ProcesoRepositorio();

	}

	public Integer persistirDocumento(Documento documento, Integer idProceso) {
		Integer idAsignado = null;
		Proceso procesoBuscado = procesoRepositorio.buscaProceso(idProceso);
		if (!ValidarInformacion.esNulo(documento) && procesoBuscado != null) {
			try {
				etx.begin();
				documento.setProceso(procesoBuscado);
				em.persist(documento);
				etx.commit();
				idAsignado = documento.getIdDocumento();
			} catch (Exception e) {
				etx.rollback();
			}finally{
				em.close();
				emf.close();
			}
		}
		return idAsignado;
	}

	public Documento buscarDocumento(Integer idDocumento){
		return em.find(Documento.class, idDocumento);
	}
}
