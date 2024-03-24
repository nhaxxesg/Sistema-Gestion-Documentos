package app.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import app.entidades.*;
import app.entidades.repositorios.DocumentoRepositorio;
import app.entidades.repositorios.ObservacionRepositorio;
import app.entidades.repositorios.ProcesoRepositorio;
import app.entidades.repositorios.UsuarioRepositorio;

public class ControladorRegistrarProceso {
    private UsuarioRepositorio usuarioRepositorio;
    private ProcesoRepositorio procesoRepositorio;
    private ObservacionRepositorio observacionRepositorio;
    private DocumentoRepositorio documentoRepositorio;
    private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

    public ControladorRegistrarProceso(){
        this.usuarioRepositorio = new UsuarioRepositorio();
        this.procesoRepositorio = new ProcesoRepositorio();
        this.observacionRepositorio = new ObservacionRepositorio();
        this.documentoRepositorio = new DocumentoRepositorio();
        this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
    }

    public void registrarProceso(Usuario usuario){
        if(em.find(Usuario.class, usuario.getCodigo()) == null){
            usuarioRepositorio.persistirUsuarioRefactorizado(usuario);
        }else{
            procesoRepositorio.persistirProcesoRefactorizado(usuario.getProcesos().get(0));
        }
        
    }

    public void informacionProcesos(){
        
    }

}
